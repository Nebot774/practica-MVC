package com.example.practiccamvvm;

public class NumberModel {
    //clase NumberModel  Tiene una propiedad para almacenar un número y métodos para establecer este número y duplicarlo
    private int number;

    //metodo para almacenar el numero ,
    public void setNumber(int newNumber) {
        if (newNumber <= 0) {
            throw new IllegalArgumentException("Number must be greater than zero.");//lanzamos excepcion si el numero es menor a 0
        }
        number = newNumber;
    }

    //metodo para duplicar el numero
    public int doubleNumber() {
        return number * 2;
    }
}
