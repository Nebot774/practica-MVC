package com.example.practiccamvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<String> result = new MutableLiveData<>();
    private final NumberModel model = new NumberModel();

    public LiveData<String> getResult() {
        return result;
    }

    public void doubleTheNumber(int number) {
        try {
            model.setNumber(number);
            int doubledValue = model.doubleNumber();
            result.setValue("Result: " + doubledValue);
        } catch (IllegalArgumentException e) {
            result.setValue(e.getMessage());
        }
    }

    public void setResult(String message) {
        result.setValue(message);
    }
}
