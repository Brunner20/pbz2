package view;

import DAO.EmployeeDAO;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Employee;

import java.sql.SQLException;
import java.util.Date;

public class EmployeeWindow {

      private TableView<Employee> table;
      private final EmployeeDAO employeeDAO;

      private AnchorPane anchorPane;
      private TextField name;
      private TextField age;
      private TextField birth;
      private TextField gender;
      private TextField subdivision;
      private TextField position;
      private DatePicker start;
      private DatePicker end;
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

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    private void createTable(ObservableList<Employee> employees)  {


          if(employees.isEmpty()){

                  Label deleted=new Label("значения не найдены");
                  GridPane grid =new GridPane();
                  grid.setHgap(10);
                  grid.add(deleted,0,0);
                  Stage dialogWindow =new Stage();
                  dialogWindow.setScene(new Scene(grid,300,150));
                  dialogWindow.show();

          }

          table.setItems(employees);


      }

      private void configureWin(){
          anchorPane = new AnchorPane();
          configureAddEmployeePane();
          configureTable();
          configureSearch();
      }
      private void configureAddEmployeePane(){

          GridPane gridForAddEmp = new GridPane();
          Separator vert =new Separator(Orientation.VERTICAL);
          Separator hor =new Separator(Orientation.HORIZONTAL);
          Label nameLa = new Label("ФИО");
          Label ageLa = new Label("возраст");
          Label birthLa =  new Label("год рождения");
          Label genderLa = new Label("пол");
          Label subdivisionLa = new Label("номер подразделения");
          Label positionLa = new Label("должность");
          Label startLa = new Label("дата начала работы");
          Label endLa = new Label("дата окончания работы");
         
          name =new TextField();
          age = new TextField();
          birth = new TextField();
          gender = new TextField();
          subdivision = new TextField();
          position = new TextField();
          start = new DatePicker();
          end = new DatePicker();

          add = new Button("добавить");
          update = new Button("обновить выделенного");
          add.setPrefSize(109,48);
          update.setPrefSize(109,48);

          gridForAddEmp.add(nameLa,0,0,1,1);
          gridForAddEmp.add(name,1,0,1,1);
          gridForAddEmp.add(ageLa,0,1,1,1);
          gridForAddEmp.add(age,1,1,1,1);
          gridForAddEmp.add(birthLa,0,2,1,1);
          gridForAddEmp.add(birth,1,2,1,1);
          gridForAddEmp.add(genderLa,0,3,1,1);
          gridForAddEmp.add(gender,1,3,1,1);
          gridForAddEmp.add(subdivisionLa,0,4,1,1);
          gridForAddEmp.add(subdivision,1,4,1,1);
          gridForAddEmp.add(positionLa,0,5,1,1);
          gridForAddEmp.add(position,1,5,1,1);
          gridForAddEmp.add(startLa,0,6,1,1);
          gridForAddEmp.add(start,1,6,1,1);
          gridForAddEmp.add(endLa,0,7,1,1);
          gridForAddEmp.add(end,1,7,1,1);
          gridForAddEmp.add(add,0,9,1,1);
          gridForAddEmp.add(update,1,9,1,1);
          gridForAddEmp.setVgap(5);

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

          searchByAgeAndGender = new Button("поиск ");
          searchBySubdivision = new Button("поиск ");
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
}
