package onix.mediline.accounts.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import onix.mediline.accounts.management.UsersManagement;
import onix.mediline.accounts.roles.Medic;
import onix.mediline.accounts.roles.User;

public class AdmPage3 extends AdmPages {

    @FXML
    private TableView<User> tvActivationKeys;

    @FXML
    TableColumn<User, String> colEmail, colActivationKey;

    @Override
    public void setup() {
        fillTvDelRequests();
    }

    public void fillTvDelRequests() {
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colActivationKey.setCellValueFactory(new PropertyValueFactory<>("activationKey"));
        ObservableList<Medic> data = FXCollections.observableArrayList(UsersManagement.getAllMed());
        ObservableList<User> notActivatedAccounts = FXCollections.observableArrayList();
        for (Medic i : data)
            if (!i.getContActiv())
                notActivatedAccounts.add(i);
        tvActivationKeys.setItems(notActivatedAccounts);
    }

}
