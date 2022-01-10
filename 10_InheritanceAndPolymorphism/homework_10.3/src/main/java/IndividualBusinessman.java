public class IndividualBusinessman extends Client {

    public void put(double amountToPut) {
        if (amountToPut > 0.0 && amountToPut < 1000.0) {
            accountBalance = accountBalance + amountToPut * 0.99;
        }
        if (amountToPut >= 1000.0) {
            accountBalance = accountBalance + amountToPut * 0.995;
        }
    }
    public String conditions() {
    return "пополнение с комиссией 1%, если сумма меньше 1 000 рублей. И пополнение с комиссией 0,5%, если сумма больше либо равна 1 000 рублей";
    }
}
