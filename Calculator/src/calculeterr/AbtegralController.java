/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculeterr;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Pc.unique
 */
public class AbtegralController implements Initializable {

    @FXML
    private ComboBox<Integer> tAWAN;
    @FXML
    private TextField nuM2;
    @FXML
    private TextField nuM1;
    @FXML
    private Button nEXT;
    @FXML
    private VBox ZARIB;
    @FXML
    private TextField ANS;
    @FXML
    private Button AnsWER;
    int t,r,q;
    private TextField[] textField=new TextField[900];
    private Label[] label=new Label[900];
    private HBox[] hbox=new HBox[100];
    private ArrayList<Integer>[] num=new ArrayList[300];
    private ArrayList<Integer>[] zarib=new ArrayList[300];
    private ArrayList<Integer>[] nuMM=new ArrayList[3];
    private ArrayList<Integer> kasr=new ArrayList<>();
    private ArrayList<Integer>[] plus=new ArrayList[2];
    private ArrayList<Integer> ans=new ArrayList<>();
    @FXML
    private Button del;
    @FXML
    private Button del1;
    String answer=new String();
    //private String[] Num=new String[300];
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        tAWAN.getItems().add(0);
        tAWAN.getItems().add(1);
        tAWAN.getItems().add(2);
        tAWAN.getItems().add(3);
        tAWAN.getItems().add(4);
        tAWAN.getItems().add(5);
        tAWAN.getItems().add(6);
        tAWAN.getItems().add(7);
        tAWAN.getItems().add(8);
        tAWAN.getItems().add(9);
        
    }    

    @FXML
    private void nEXT(ActionEvent event) {
          ZARIB.getChildren().clear();
        if(isNumeric(nuM1.getText())==false){
           JOptionPane.showMessageDialog(null," عدد اول باید ازعدد تشکیل شود");
        }else if(isNumeric(nuM2.getText())==false){
            JOptionPane.showMessageDialog(null," عدد دوم باید از عدد تشکیل شود");
        }else if(tAWAN.getValue()==null){
            JOptionPane.showMessageDialog(null,"توان نمی تواند خالی باشد");
        }else{
            String[] Num1=nuM1.getText().split("");
            String[] Num2=nuM2.getText().split("");
            nuMM[0]=new ArrayList<>();
            nuMM[1]=new ArrayList<>();
            for(r=0;r<Num1.length;r++){
             nuMM[0].add(Integer.parseInt(Num1[r]));
            }
            for(r=0;r<Num2.length;r++){
             nuMM[1].add(Integer.parseInt(Num2[r]));
            }
            
            for(r=0;r<=tAWAN.getValue();r++){
                hbox[r]=new HBox();
                textField[r]=new TextField();
                label[r]=new Label();
                textField[r]=new TextField();
                label[r]=new Label(r +"ضریب جمله ");
                hbox[r].getChildren().add(textField[r]);
                hbox[r].getChildren().add(label[r]);
                ZARIB.getChildren().add(hbox[r]);
            }
            
        }
    }

    @FXML
    private void AnsWER(ActionEvent event) {
        for(r=0;r<=tAWAN.getValue();r++){
           if(textField[r].getText().equals("")){
             JOptionPane.showMessageDialog(null,"نمی تواند خالی باشد "+r+ "ضریب  جمله ");
           }if(isNumeric(textField[r].getText())==false){
           JOptionPane.showMessageDialog(null," باید عدد باشد "+r+" ضریب جمله ");
        }
        }
        for(r=0;r<=tAWAN.getValue();r++){
           String[] Num=textField[r].getText().split("");
           zarib[r]=new ArrayList<>();
           for(t=0;t<Num.length;t++){
             zarib[r].add(Integer.parseInt(Num[t]));
           }
        }
        q=0;
        int P=tAWAN.getValue(),e=-1;
        kasr=new ArrayList<>();
        kasr.add(0);
        while(q<2){
          plus[q]=new ArrayList<>();  
          plus[q].add(0);
          if(q==1){
            t=tAWAN.getValue()+1;
            P=tAWAN.getValue()*2+1;
            e=-1;
          }else{  
            t=0;  
          }  
          for(;t<=P;t++){
            e++;  
            kasr.set(0, e+1);
            num[t]=new ArrayList<>();
            num[t].add(1);
            if(zarib[e].size()==1 && zarib[e].get(0)==0){
              num[t].set(0,0);
            }else{
                FXMLDocumentController method=new FXMLDocumentController();
                for(r=0;r<=e;r++){
                  
                  num[t]=method.zarb(nuMM[q],num[t]);
       
                }
               // System.out.println();
                //System.out.println(zarib[e]);
                num[t]=method.zarb(zarib[e],num[t]);
                //System.out.println();
                method.num1=num[t];
                method.numberr="∫";
                num[t]=method.dive(num[t], kasr);
                plus[q]=method.zarbForPluss(plus[q], num[t]);
            }
          }
          q++;
        }
        FXMLDocumentController method=new FXMLDocumentController();
        method.numberr="∫";
        /*System.out.println();
        System.out.println(t);
        for(r=0;r<t;r++){
         System.out.println(num[r]);
        }
        System.out.println();
        System.out.println(plus[0]);
        System.out.println(plus[1]);
        System.out.println();
*/
        ans=method.miness(plus[0], plus[1]);
        for(t=0;t<ans.size();t++){
          answer+=Integer.toString(ans.get(t));
        }
        ANS.setText(answer);
        
        
    }
    
    public  boolean isNumeric(String s) {    
    return java.util.regex.Pattern.matches("\\d+", s);
    }

    @FXML
    private void Del(ActionEvent event) {
        nuM1.setText("");
        nuM2.setText("");
        ANS.setText("");
        ZARIB.getChildren().clear();    
        tAWAN.setValue(null);
        answer=new String();
        
        textField=new TextField[900];
        label=new Label[900];
        hbox=new HBox[100];
        num=new ArrayList[300];
        zarib=new ArrayList[300];
        nuMM=new ArrayList[3];
        kasr=new ArrayList<>();
        ans=new ArrayList<>();
        plus=new ArrayList[2];
    
    }

    @FXML
    private void returnn(ActionEvent event) throws IOException {
        
         Parent tableViewParent=FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
         Scene tableViewScene=new Scene(tableViewParent);
         Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(tableViewScene);
         window.show();
        
    }
    
}
