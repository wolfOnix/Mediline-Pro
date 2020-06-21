package onix.mediline.accounts.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import onix.mediline.accounts.exceptions.NoRowSelected;
import onix.mediline.accounts.management.UsersManagement;
import onix.mediline.accounts.roles.Admin;
import onix.mediline.accounts.roles.Medic;
import onix.mediline.accounts.roles.Pacient;
import onix.mediline.accounts.roles.User;

public class AdmPage2 extends AdmPages {

    User selectedUser;
    boolean selected = false;

    @FXML
    Label lbAccType, lbInfo;

    @FXML
    public TableView<User> tvDelRequests;

    @FXML
    TableColumn<User, String> colEmail, colNumeFam;

    @Override
    public void setup() {
        fillTvDelRequests();
    }

    public void fillTvDelRequests() {
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colNumeFam.setCellValueFactory(new PropertyValueFactory<>("nume"));
        ObservableList<User> data = FXCollections.observableArrayList(UsersManagement.getAllMed());
        data.addAll(UsersManagement.getAllPac());
        ObservableList<User> delRequests = FXCollections.observableArrayList();
        for (User i : data)
            if (i.getRequestDelete())
                delRequests.add(i);
        tvDelRequests.setItems(delRequests);
    }

    @FXML
    void tvClicked (MouseEvent event) {
        selectedUser = tvDelRequests.getSelectionModel().getSelectedItem();
        selected = true;
        setLbAccType(selectedUser);
    }

    public void confirmDelAccount() {
        try {
            if (!selected || selectedUser == null)
                throw new NoRowSelected();
            UsersManagement.removeUser(selectedUser);
            setMessageLabel("Utilizatorul a fost șters");
            lbInfo.setText("");
            lbAccType.setText("");
            selected = false;
            selectedUser = null;
            this.fillTvDelRequests();
        }  catch (NoRowSelected e) {
            super.setErrorText(e);
            lbInfo.setText("");
        }
    }

    public void rejectDelAccount(ActionEvent event) {
        try {
            if (!selected || selectedUser == null)
                throw new NoRowSelected();
            User oldUser = selectedUser;
            selectedUser.setRequestDelete(false);
            UsersManagement.updateUser(oldUser, selectedUser);
            lbAccType.setText("");
            lbInfo.setText("");
            setMessageLabel("Cererea de ștergere a fost respinsă");
            selected = false;
            selectedUser = null;
            this.fillTvDelRequests();
        }  catch (NoRowSelected e) {
            super.setErrorText(e);
            lbInfo.setText("");
        }
    }

    private void setLbAccType(User user) {
        String s = "Tip cont: ";
        if (user instanceof Admin)
            lbAccType.setText(s + "Administrator");
        else if (user instanceof Medic)
            lbAccType.setText(s + "Medic");
        else if (user instanceof Pacient)
            lbAccType.setText(s + "Pacient");
    }

    public void btBack(ActionEvent event) {

    }

}
