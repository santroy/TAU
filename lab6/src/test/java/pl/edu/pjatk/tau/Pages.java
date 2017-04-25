package pl.edu.pjatk.tau;


import org.jbehave.web.selenium.WebDriverProvider;

import pl.edu.pjatk.tau.pages.CarGarage;

public class Pages {

    private WebDriverProvider driverProvider;

    //Pages -- moze byc ich kilka
    private CarGarage carGarage;

    public Pages(WebDriverProvider driverProvider) {
        super();
        this.driverProvider = driverProvider;
    }

    public CarGarage carGarage() {
        if (carGarage == null) {
            carGarage = new CarGarage(driverProvider);
        }
        return carGarage;
    }
}