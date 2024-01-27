package com.test.demo.TestingPackage;

import com.test.demo.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;

public class TestingTableview extends Application{

        public static void main(String[] args) {
            launch();
        }

        @Override
        public void start(Stage stage) throws IOException {

            GridPane gridPane = new GridPane();
            gridPane.add(new Label("Annual interest rate: "),0,0);
            gridPane.add(new Label("Number of years: "),0,1);
            gridPane.add(new Label("Loan amount: "),0,2);
            gridPane.add(new Label ("Monthly payment: "),0,3);
            gridPane.add(new Label("Total payment: "),0,4);

            TextField tfAnnualInterestRate = new TextField();
            TextField tfNumberOfYears = new TextField();
            TextField tfLoanAmount = new TextField();
            TextField tfMonthlyPayment = new TextField();
            TextField tfTotalPayment = new TextField();
            Button btCalculate = new Button("Calculate");

            btCalculate.setOnAction(e-> {
                if(tfAnnualInterestRate.getText()==null ||tfNumberOfYears.getText()==null||tfLoanAmount.getText()==null){
                    gridPane.add(new Label("Error getting data! "),0,5);
                }
                else{
                    double interestRate = Double.parseDouble(tfAnnualInterestRate.getText());
                    int numberOfYears = Integer.parseInt(tfNumberOfYears.getText());
                    double loanAmount = Double.parseDouble(tfLoanAmount.getText());

                    double totalPayment = loanAmount;
                    for(int i=0;i<numberOfYears;i++){
                        totalPayment+=(totalPayment*interestRate)/100;
                    }

                    double monthlyPayment = totalPayment/(numberOfYears*12);
                    tfMonthlyPayment.setText(String.valueOf(monthlyPayment));
                    tfTotalPayment.setText(String.valueOf(totalPayment));
                }

        });


            gridPane.add(tfAnnualInterestRate,1,0);
            gridPane.add(tfNumberOfYears,1,1);
            gridPane.add(tfLoanAmount,1,2);
            gridPane.add(tfMonthlyPayment,1,3);
            gridPane.add(tfTotalPayment,1,4);
            gridPane.add(btCalculate,1,5);


            Scene scene = new Scene(gridPane);



            stage.setScene(scene);
            stage.show();
        }








}
