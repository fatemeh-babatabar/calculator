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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Pc.unique
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button btn1;
    @FXML
    private Button btn3;
    @FXML
    private Button btn2;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn9;
    @FXML
    private Button btn8;
    @FXML
    private Button btn7;
    @FXML
    private Button multi;
    @FXML
    private Button sub;
    @FXML
    private Button plus;
    @FXML
    private Button equal;
    @FXML
    private Button remainder;
    @FXML
    private Button division;
    @FXML
    private Button btn0;
    @FXML
    private Button integral;
    @FXML
    private TextField textField;
    String numberr="";
    ArrayList<Integer> num1=new ArrayList<>();
    ArrayList<Integer> num2=new ArrayList<>();
    ArrayList<Integer> num3=new ArrayList<>();
    ArrayList<Integer> num4=new ArrayList<>();
    int i,j,maxx=0;
    boolean numberic;
    @FXML
    private Button DEL;
    @FXML
    private TextField ANS;
    String Ans=new String();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Btn1(ActionEvent event) {
        numberr=textField.getText();
        numberr+="1";
        textField.setText(numberr);
    }

    @FXML
    private void Btn3(ActionEvent event) {
        numberr=textField.getText();
        numberr+="3";
        textField.setText(numberr);
    }

    @FXML
    private void Btn2(ActionEvent event) {
        numberr=textField.getText();
        numberr+="2";
        textField.setText(numberr);
    }

    @FXML
    private void Btn4(ActionEvent event) {
        numberr=textField.getText();
        numberr+="4";
        textField.setText(numberr);
    }

    @FXML
    private void Btn5(ActionEvent event) {
        numberr=textField.getText();
        numberr+="5";
        textField.setText(numberr);
    }

    @FXML
    private void Btn6(ActionEvent event) {
        numberr=textField.getText();
        numberr+="6";
        textField.setText(numberr);
    }

    @FXML
    private void Btn9(ActionEvent event) {
        numberr=textField.getText();
        numberr+="9";
        textField.setText(numberr);
    }

    @FXML
    private void Btn8(ActionEvent event) {
        numberr=textField.getText();
        numberr+="8";
        textField.setText(numberr);
    }

    @FXML
    private void Btn7(ActionEvent event) {
        numberr=textField.getText();
        numberr+="7";
        textField.setText(numberr);
    }

    @FXML
    private void Multi(ActionEvent event) {
        numberr=textField.getText();
        numberr+="x";
        textField.setText(numberr);
    }

    @FXML
    private void Sub(ActionEvent event) {
        numberr=textField.getText();
        numberr+="-";
        textField.setText(numberr);
    }

    @FXML
    private void Plus(ActionEvent event) {
        numberr=textField.getText();
        numberr+="+";
        textField.setText(numberr);
    }

    @FXML
    private void Equal(ActionEvent event) {
        numberr=textField.getText();
       if(numberr.contains("+")){
         sameSize("\\+");
         if(numberic==true){    
          if(num1.size()==1 && num1.get(0)==0){
            num4=num2;
          }else if(num2.size()==1 && num2.get(0)==0){
            num4=num1;
          }else{   
            num4=zarbForPluss(num1,num2);
          }  
          print(num4);
         }
       }else if(numberr.contains("-")){
         sameSize("-");
         if(numberic==true){
           if(num1.equals(num2)){
              ANS.setText("0");
           }else if(num1.size()==1 && num1.get(0)==0){
             Ans+="-";
             num4=num2;
             print(num4);
           }else if(num2.size()==1 && num2.get(0)==0){
             num4=num1;
             print(num4);
           }else{
              maxx=Maxx(num1,num2);
              if(maxx==1){
                num4=miness(num1,num2);
                print(num4);
              }else{
                Ans+="-";
                num4=miness(num2,num1);
                print(num4);
              }
           }
         }
       }else if(numberr.contains("÷")){
        sameSize("÷");  
        if(numberic==true){
          if(num1.size()==1 && num1.get(0)==0) {
            ANS.setText("0");
          }else if(num2.size()==1 && num2.get(0)==0){
              // lalamate binahaiat
            ANS.setText("∞");
          }else if(num2.size()==1 && num2.get(0)==1){
            num4=num1;
            print(num4);
          }else if(Maxx(num1,num2)==0){
            ANS.setText("0");
          }else if(num1.equals(num2)){
            ANS.setText("1");
          }else {
           num4=dive(num1,num2);
           print(num4);
          }
        }  
       }else if(numberr.contains("x")){
        sameSize("x");   
        if(numberic==true){
          if((num1.size()==1 && num1.get(0)==0) || (num2.size()==1 && num2.get(0)==0)){
             ANS.setText("0");         
          }else{  
            num4=zarb(num1,num2);  
            print(num4);
          }  
        }  
       }else if(numberr.contains("%")){
        sameSize("%");   
        if(numberic==true){
          if(num1.size()==1 && num1.get(0)==0){
            ANS.setText("0");          
          }else if(num2.size()==1 && num2.get(0)==0){
            /////////////////////
          }else if(num2.size()==1 && num2.get(0)==1){
            ANS.setText("0");
          }else if(Maxx(num1,num2)==0){
            num4=num1;  
            print(num4);
          }else if(num1.equals(num2)){
            ANS.setText("0");
          }else{  
            num4=dive(num1,num2);
            print(num4);
          }  
            
        }  
       }
    }

    @FXML
    private void Remainder(ActionEvent event) {
        numberr+="%";
        textField.setText(numberr);
    }

    @FXML
    private void Division(ActionEvent event) {
        numberr+="÷";
        textField.setText(numberr);
    }

    @FXML
    private void Btn0(ActionEvent event) {
        numberr+="0";
        textField.setText(numberr);
    }

    @FXML
    private void Integral(ActionEvent event) throws IOException {
            
         Parent tableViewParent=FXMLLoader.load(getClass().getResource("Abtegral.fxml"));
         Scene tableViewScene=new Scene(tableViewParent);
         Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(tableViewScene);
         window.show();
    }
    public void sameSize(String T){
      numberic=false;  
      AbtegralController method=new   AbtegralController();
      String[] num=numberr.split(T);
      String[] Num1=num[0].split("");
      String[] Num2=num[1].split("");
      
      if(method.isNumeric(num[0])==false){
         JOptionPane.showMessageDialog(null," عدد اول باید ازعدد تشکیل شود");
         numberic=false;
      }else if(method.isNumeric(num[1])==false){
         JOptionPane.showMessageDialog(null," عدد دوم باید از عدد تشکیل شود");
         numberic=false;
      }else{
        
        for(i=0;i<Num1.length;i++){
          num1.add(Integer.parseInt(Num1[i]));
        }
        for(i=0;i<Num2.length;i++){
          num2.add(Integer.parseInt(Num2[i]));
        }if((num1.size()!=1 && num1.get(0)==0)|| (num2.size()!=1 && num2.get(0)==0 )){
          JOptionPane.showMessageDialog(null," رقم اول عدد نمیتواند صفر باشد");
        }else{
          numberic=true;
          if(!numberr.contains("x") && !numberr.contains("%") && !numberr.contains("÷") && !numberr.contains("∫")){
            if(num2.size()>num1.size()){
              while(num1.size()<num2.size()){
                num1.add(0,0);
              }
            }else if(num1.size()>num2.size()){
              while(num2.size()<num1.size()){
                num2.add(0,0);
              }
            }
          }
        }
      }
    }
    public ArrayList<Integer> zarb(ArrayList<Integer> N1,ArrayList<Integer> N2){

      ArrayList<Integer> N3=new ArrayList<>();
      ArrayList<Integer> N4=new ArrayList<>();
      N3.add(0);
      int zarb,k,count=-1,o=0;
      for(i=N1.size()-1;i>=0;i--){
        N4=new ArrayList<>();
        k=0;zarb=0;
        count++;
        for(j=N2.size()-1;j>=0;j--){
           zarb=(N2.get(j)*N1.get(i))+k;
         
           if(zarb>9){
             k=zarb/10;
             zarb%=10;
           }else{
             k=0;
           }
           N4.add(0,zarb);
        }
        if(k!=0){
           N4.add(0,k);
        }
        
        for(o=0;o<count;o++){
            N4.add(0);
        }
        N3=zarbForPluss(N3,N4); 
      }
      return N3;
    }
    public ArrayList<Integer> zarbForPluss(ArrayList<Integer> N1,ArrayList<Integer> N2){
        
        int p,sum=0,k=0;
        num3=new ArrayList<>();
        if(N1.size()>N2.size()){
            while(N1.size()>N2.size()){
                  N2.add(0,0);
            }
        }else if(N2.size()>N1.size()){
            while(N2.size()>N1.size()){
                  N1.add(0,0);
            }      
        }
        for(p=N1.size()-1;p>=0;p--){
          sum=N1.get(p)+N2.get(p)+k;
          if(sum>9){
            k=sum/10;
            sum%=10;
          }else{
            k=0;
          }
          num3.add(0,sum);
        }
        if(k!=0){
         num3.add(0,k);
        }
        return num3;
    }
    public int Maxx(ArrayList<Integer> N1,ArrayList<Integer> N2){
       maxx=0;
       int y;
       if(N1.size()>N2.size()){
         maxx=1;
         return maxx;
       }else if(N1.size()<N2.size()){
         maxx=0;
         return maxx;
       }
       else if(N1.size()==N2.size()){
           if(N1.equals(N2)){
             maxx=1;
             return maxx;
           }
         for(y=0;y<=N2.size()-1;){
           if(N1.get(y)==N2.get(y)){
               y++;
           }else if(N1.get(y)>N2.get(y)){
               maxx=1;
               return maxx;
           }else if(N1.get(y)<N2.get(y)){
               maxx=0;
               return maxx;
           }
         }  
       } 
       return maxx;
    }
    public ArrayList<Integer> miness(ArrayList<Integer> N1,ArrayList<Integer> N2){
       ArrayList<Integer> N12=new ArrayList<>();
       ArrayList<Integer> N13=new ArrayList<>();
       int h,k,mines;
       
       ArrayList<Integer> N5=new ArrayList<>();
       if(N1.size()>N2.size() && (numberr.contains("÷") || numberr.contains("%") || numberr.contains("∫")) ){
          int y=N2.size();
          while(N1.size()>y){
            y++;  
            N12.add(0);
          }       
       }
       for(h=0;h<N2.size();h++){
         N12.add(N2.get(h));
       }
       for(h=N1.size()-1;h>=0;h--){
         if(N1.get(h)<N12.get(h)){
           N1.set(h, N1.get(h)+10);
           k=h-1;
           while(k>=0 && N1.get(k)==0){
             N1.set(k, 9);
             k--;
           }
           N1.set(h-1, N1.get(h-1)-1);
         }
         mines=N1.get(h)-N12.get(h);
         N5.add(0,mines);
       }
        
       if(N1.equals(N2)){
         N13.add(0);
       }else{
       
       k=0;
       while(N5.get(k)==0 ){
         k++;
       }       
       for(h=k;h<N5.size();h++){
         N13.add(N5.get(h));
       }
       /*
       for(h=k;h<N5.size();h++){
         System.out.print(N5.get(h));
       }
*/
       }
       return N13;
    }
    public ArrayList<Integer> dive(ArrayList<Integer> N1,ArrayList<Integer> N2){
      ArrayList<Integer> N6=new ArrayList<>();
      ArrayList<Integer> N7=new ArrayList<>();  
      ArrayList<Integer> N8=new ArrayList<>();
      ArrayList<Integer> N9=new ArrayList<>();
      ArrayList<Integer> N10=new ArrayList<>();
      N8.add(9);
      int m=0,k,h,P=0,count,C=0,U;
      N7.add(0);
      while((Maxx(N1,N2)==1 || N1.equals(N2)) && P<=num1.size()){
                       
               m=0;
               h=N2.size(); 
               P++;
               count=0;
               while(m==0 && P<=num1.size()){
                  C++; 
                  count++; 
                  if(N7.size()==1 && N7.get(0)==0 && count!=1){
                    P++;
                  }   
                  N8.set(0, 9); 
                  N6=new ArrayList<>();
                  for(k=0;k<h;k++){
                    N6.add(N1.get(k));
                  }
                  
                  if(N7.size()==1 && N7.get(0)==0 && Maxx(N6,N2)==0 && C!=1){
                    N9.add(0);
                  } 
                  
                  int u;          
                 
                  if(Maxx(N6,N2)==1 || N6.equals(N2)){
                  
                    while(Maxx(N6,zarb(N2,N8))==0){
                        u=N8.get(0)-1;
                        N8.set(0, u);
                    }
                    N7=new ArrayList<>();
                    N7=miness(N6,zarb(N2,N8));                  
                    N9.add(N8.get(0));
                    N1=new ArrayList<>();
                    if(N7.size()==1 && N7.get(0)==0){
                        
                      for(U=P;U<num1.size();U++){
                         if(num1.get(U)==0){
                            N9.add(0);
                            P++;
                         }else{
                           break;
                         }
                      }
                    }
                    else{
                      for(k=0;k<N7.size();k++){
                        N1.add(N7.get(k));
                      }
                    }
                    
                    
                    for(k=P;k<num1.size();k++){
                      N1.add(num1.get(k));
                    }
                    
                    if(Maxx(N1,N2)==0 && N1.size()>0 && !N1.equals(N7)){
                      N9.add(0);
                      N7=new ArrayList<>();
                      N7=N1;
                    }
                    
                    m=1; 
                  }
                  else{
                    h++;
                  }
               
                  }
      }
      
    //  System.out.println(N9+"ooooooooooooooo");
    //  System.out.println(N7+"tttttttttttttt");
      
      if(numberr.contains("%")){
        return N7;
      }else{
        return N9;
      }
    }

    @FXML
    private void DELITE(ActionEvent event) {
        numberr="";
        textField.setText("");
        ANS.setText("");
        num1=new ArrayList<>();
        num2=new ArrayList<>();
        num3=new ArrayList<>();
        num4=new ArrayList<>();
        Ans=new String();
    }
    private void print(ArrayList<Integer> N1){
        
       for (int y=0;y<N1.size();y++){
          Ans+=Integer.toString(N1.get(y));
       }
       ANS.setText(Ans);
    }
}
