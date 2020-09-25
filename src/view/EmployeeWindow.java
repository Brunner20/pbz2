package view;

import DAO.EmployeeDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.Employee;

import java.sql.SQLException;
import java.sql.Date;

public class EmployeeWindow {

      private final TableView<Employee> table;
      private  EmployeeDAO employeeDAO ;

      private AnchorPane anchorPane;
      private TextField idUpd;
      private TextField name;
      private TextField age;
      private TextField ageUpd;
      private TextField birth;
      private TextField gender;
      private TextField subdivision;
      private TextField position;
      private TextField positionUpd;
      private DatePicker start;
      private DatePicker end;
      private DatePicker endUpd;
      private Button add;
      private Button update;

      private TextField subdivisionForSearch;
      private TextField genderForSearch;
      private TextField ageForSearch;
      private TextField id;
      private Button searchBySubdivision;
      private Button searchByAgeAndGender;
      private Button delete;

      public EmployeeWindow() throws SQLException {
          table = new TableView<>();
          employeeDAO= new EmployeeDAO();
          configureWin();
          createTable(employeeDAO.findAllEmployee());

      }

    public AnchorPane getAnchorPane() { return anchorPane; }

    private void createTable(ObservableList<Employee> employees)  {
        table.setItems(employees);
      }

      private void configureWin(){
          anchorPane = new AnchorPane();
          configureAddEmployeePane();
          configureTable();
          configureSearch();
          configureUpdate();
          searchByAgeAndGender.setOnAction(searchAge);
          searchBySubdivision.setOnAction(searchSub);
          add.setOnAction(addEmp);
          delete.setOnAction(deleteEmp);
          update.setOnAction(updateEmp);
      }
      private void configureAddEmployeePane(){

          GridPane gridForAddEmp = new GridPane();
          Separator vert =new Separator(Orientation.VERTICAL);
          Separator hor =new Separator(Orientation.HORIZONTAL);

          name =new TextField();
          age = new TextField();
          birth = new TextField();
          gender = new TextField();
          subdivision = new TextField();
          position = new TextField();
          start = new DatePicker();
          end = new DatePicker();

          name.setPromptText("ФИО");
          age.setPromptText("возраст");
          birth.setPromptText("год рождения");
          gender.setPromptText("пол");
          subdivision.setPromptText("номер подразделения");
          position.setPromptText("должнось");
          start.setPromptText("дата начала работы");
          end.setPromptText("дата окончания работы");
          add = new Button("добавить");
          add.setPrefSize(109,48);


          gridForAddEmp.add(name,0,0,1,1);
          gridForAddEmp.add(age,0,1,1,1);
          gridForAddEmp.add(birth,0,2,1,1);
          gridForAddEmp.add(gender,0,3,1,1);
          gridForAddEmp.add(subdivision,0,4,1,1);
          gridForAddEmp.add(position,0,5,1,1);
          gridForAddEmp.add(start,0,6,1,1);
          gridForAddEmp.add(end,0,7,1,1);
          gridForAddEmp.add(add,0,9,1,1);
          gridForAddEmp.setHgap(5);
          gridForAddEmp.setVgap(10);

          vert.setPrefSize(20,350);
          hor.setPrefSize(920,5);

          AnchorPane.setLeftAnchor(gridForAddEmp,20.0);
          AnchorPane.setTopAnchor(gridForAddEmp,20.0);
          AnchorPane.setLeftAnchor(vert,410.0);
          AnchorPane.setTopAnchor(vert,10.0);
          AnchorPane.setLeftAnchor(hor,10.0);
          AnchorPane.setTopAnchor(hor,10.0);

          anchorPane.getChildren().addAll(gridForAddEmp,vert,hor);


      }
      private  void configureTable(){
          TableColumn<Employee,Integer> idColumn = new TableColumn<>("номер рабочего");
          TableColumn<Employee,Integer> ageColumn = new TableColumn<>("возраст рабочего");
          TableColumn<Employee,String> nameColumn = new TableColumn<>("ФИО рабочего");
          TableColumn<Employee,Integer> birthColumn = new TableColumn<>("год рождения рабочего");
          TableColumn<Employee,String> genderColumn = new TableColumn<>("пол рабочего");
          TableColumn<Employee,Integer> subdivisionColumn = new TableColumn<>("номер подразделения");
          TableColumn<Employee,Integer> positionColumn = new TableColumn<>("должность рабочего");
          TableColumn<Employee, Date> startColumn = new TableColumn<>("дата начала работы");
          TableColumn<Employee, Date> endColumn = new TableColumn<>("дата окончания работы");

          idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
          ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
          nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
          birthColumn.setCellValueFactory(new PropertyValueFactory<>("birthYear"));
          genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
          subdivisionColumn.setCellValueFactory(new PropertyValueFactory<>("subdivisionId"));
          positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
          startColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
          endColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));

          table.getColumns().addAll(idColumn,ageColumn,nameColumn,birthColumn,genderColumn,subdivisionColumn,
                  positionColumn,startColumn,endColumn);


          table.setPrefSize(720,340);
          AnchorPane.setTopAnchor(table,200.0);
          AnchorPane.setLeftAnchor(table,450.0);
          anchorPane.getChildren().addAll(table);
      }

    private void configureSearch(){

          GridPane pane= new GridPane();

          subdivisionForSearch = new TextField();
          ageForSearch = new TextField();
          genderForSearch = new TextField();
          id = new TextField();

          searchByAgeAndGender = new Button("поиск по полу и возр.");
          searchBySubdivision = new Button("поиск по подр.");
          subdivisionForSearch.setPromptText("подразделение");
          ageForSearch.setPromptText("возраст");
          genderForSearch.setPromptText("пол");
          id.setPromptText("номер");
          delete = new Button("удалить");

          delete.setPrefSize(160,30);
          searchBySubdivision.setPrefSize(160,30);
          searchByAgeAndGender.setPrefSize(160,35);

          GridPane.setHalignment(searchBySubdivision, HPos.CENTER);
          GridPane.setHalignment(searchByAgeAndGender, HPos.CENTER);
          GridPane.setHalignment(delete, HPos.CENTER);

          pane.add(subdivisionForSearch,0,0,1,1);
          pane.add(searchBySubdivision,0,3,2,1);
          pane.add(genderForSearch,2,0,1,1);
          pane.add(ageForSearch,2,1,1,1);
          pane.add(searchByAgeAndGender,2,3,2,1);
          pane.add(id, 4,0,1,1);
          pane.add(delete,4,3,1,1);
          pane.setHgap(5);
          pane.setVgap(10);

          AnchorPane.setTopAnchor(pane,20.0);
          AnchorPane.setLeftAnchor(pane,500.0);
          anchorPane.getChildren().addAll(pane);

    }

    private void configureUpdate(){

          GridPane pane = new GridPane();


        update = new Button("Обновить");
        update.setPrefSize(109,48);
        idUpd = new TextField();
        ageUpd = new TextField();
        positionUpd = new TextField();
        endUpd = new DatePicker();

        idUpd.setPromptText("номер работника");
        ageUpd.setPromptText("новый возраст");
        positionUpd.setPromptText("новая должность");
        endUpd.setPromptText("дата окончания работы");

        pane.add(update,0,4,1,1);
        pane.add(idUpd,0,0,1,1);
        pane.add(ageUpd,0,1,1,1);
        pane.add(positionUpd,0,2,1,1);
        pane.add(endUpd,0,3,1,1);

        pane.setHgap(5);
        pane.setVgap(10);

        AnchorPane.setTopAnchor(pane,420.0);
        AnchorPane.setLeftAnchor(pane,20.0);
        anchorPane.getChildren().addAll(pane);
    }

    private final EventHandler<ActionEvent> searchSub = e -> {

        try {

            if(subdivisionForSearch.getText().isEmpty()  ) excep();
            else createTable(employeeDAO.findEmployeeBySubdivision(Integer.parseInt(subdivisionForSearch.getText())));
        } catch (SQLException  throwables ) {
            throwables.printStackTrace();

        }
        catch (NumberFormatException ex){
            //если была введена не цифра
            excep();
        }


    };
    private final EventHandler<ActionEvent> searchAge = e -> {

        try {
            if(genderForSearch.getText().isEmpty() && ageForSearch.getText().isEmpty())
                excep();

            else createTable(employeeDAO.findEmployeeBySexAndAge(genderForSearch.getText()
                                                                ,Integer.parseInt(ageForSearch.getText())));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        catch (NumberFormatException ex){

            excep();
        }


    };
    private final EventHandler<ActionEvent> addEmp = e -> {

        try {

            if(Integer.getInteger(age.getText())<0) throw  new NumberFormatException();
            Employee employee =new Employee( Integer.parseInt(age.getText()),
                                name.getText(),
                                Integer.parseInt(birth.getText()),
                                gender.getText(),
                                Integer.parseInt(subdivision.getText()),
                                position.getText(),
                                Date.valueOf(start.getValue()),
                                Date.valueOf(end.getValue()));
            employeeDAO.insertIntoDB(
                                employee.getAge(),
                                employee.getName(),
                                employee.getBirthYear(),
                                employee.getGender(),
                                employee.getSubdivisionId(),
                                employee.getPosition(),
                                employee.getStartDate(),
                                employee.getEndDate());

            createTable(employeeDAO.findAllEmployee());
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        catch (NumberFormatException ex){
            excep();
        }


    };
    private final EventHandler<ActionEvent> deleteEmp = e -> {

        try {
            if(!id.getText().isEmpty()) employeeDAO.deleteInDB(Integer.parseInt(id.getText()));
                createTable(employeeDAO.findAllEmployee());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        catch (NumberFormatException ex){

            excep();
        }


    };

    private final EventHandler<ActionEvent> updateEmp = e -> {
            int id ;
            int age =0;
            String position =null;
            Date end = null;
        try {

            if(idUpd.getText().isEmpty()){ throw  new NumberFormatException();}
            else id = Integer.parseInt(idUpd.getText());
            if(!ageUpd.getText().isEmpty())
                age =Integer.parseInt(ageUpd.getText());
            if(!positionUpd.getText().isEmpty())
                position =positionUpd.getText();
            if(endUpd.getValue()!=null)
                end = Date.valueOf(endUpd.getValue());

            employeeDAO.updateDB(id,age, position,end );
            createTable(employeeDAO.findAllEmployee());

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            excep();

        }
        catch (NumberFormatException ex){

            excep();
        }


    };
    private void excep(){
        Label deleted=new Label("введены некорректные данные");
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(deleted);
        Scene secondScene = new Scene(secondaryLayout, 260, 130);
        Stage newWindow = new Stage();
        newWindow.setScene(secondScene);
        newWindow.show();
    }
}
