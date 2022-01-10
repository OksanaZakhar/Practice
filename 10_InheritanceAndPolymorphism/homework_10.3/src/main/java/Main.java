public class Main {
    public static void main(String args[]) {

        Client physicalPerson = new PhysicalPerson();
        LegalPerson legalPerson = new LegalPerson();
        IndividualBusinessman individualBusinessman = new IndividualBusinessman();

        System.out.println(physicalPerson.conditions());
        physicalPerson.put(10000);
        physicalPerson.take(2000);
        System.out.println(physicalPerson.getAmount());

        System.out.println(legalPerson.conditions());
        legalPerson.put(10000);
        legalPerson.take(2000);
        System.out.println(legalPerson.getAmount());

        System.out.println(individualBusinessman.conditions());
        individualBusinessman.put(10000);
        individualBusinessman.take(2000);
        System.out.println(individualBusinessman.getAmount());


    }

}
