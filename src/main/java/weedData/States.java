package weedData;

import java.util.stream.Stream;

public enum States {
    // Wydaje mi sie, ze podwojne cudzyslowy nie sa tu potrzebne
    AL("\"Alabama\""),AK("\"Alaska\""),AZ("\"Arizona\""),AR("\"Arkansas\""),
    CA("\"California\""),CO("\"Colorado\""),CT("\"Connecticut\""),
    DE("\"Delaware\""), DC("\"District of Columbia\""),
    FL("\"Florida\""),
    GA("\"Georgia\""),
    HI("\"Hawaii\""),
    ID("\"Idaho\""), IL("\"Illinois\""), IN("\"Indiana\""), IA("\"Iowa\""),
    KS("\"Kansas\""),KY("\"Kentucky\""),
    LA("\"Louisiana\""),
    ME("\"Maine\""),MD("\"Maryland\""),MA("\"Massachusetts\""),MI("\"Michigan\""),MN("\"Minnesota\""),
    MS("\"Mississippi\""),MO("\"Missouri\""),MT("\"Montana\""),
    NE("\"Nebraska\""), NV("\"Nevada\""), NH("\"New Hampshire\""), NJ("\"New Jersey\""), NM("\"New Mexico\""),
    NY("\"New York\""), NC("\"North Carolina\""), ND("\"North Dakota\""),
    OH("\"Ohio\""),OK("\"Oklahoma\""),OR("\"Oregon\""),
    PA("\"Pennsylvania\""),
    RI("\"Rhode Island\""),
    SC("\"South Carolina\""), SD("\"South Dakota\""),
    TN("\"Tennessee\""), TX("\"Texas\""),
    UT("\"Utah\""),
    VT("\"Vermont\""), VA("\"Virginia\""),
    WA("\"Washington\""), WV("\"West Virginia\""), WI("\"Wisconsin\""),WY("\"Wyoming\""),
    UNKNOWN("Unkown");


    private String name;

    States(String name) {
        this.name = name;
    }

    // Nieuzywana metoda
    public static String stateAsString(States statesName){
        return Stream.of(values())
                .filter(states -> states.equals(statesName))
                .map(states -> states.name)
                .findAny()
                .orElse(States.UNKNOWN.name);
    }

    // Fajnie, ze wyprobowales dwa podejscia
    // Zwyczajowo tutaj stosuje sie nazwe metody 'of'
    // Czyli tu by bylo 'public static States of(String stateName)'
    public static States stateAbbrevation(String stateName){
        //Imperative
/*        for (States ab : States.values()){
            System.out.println("ab.name >>> "+ab.name);
            System.out.println("stateName >>> " + stateName);
            if (ab.getName().equals(stateName)){
                System.out.println(ab);
                return ab;
            }
        }
        return States.UNKNOW;*/
        return Stream.of(values())
                .filter(states -> states.name.equals(stateName))
                .findAny()
                .orElse(States.UNKNOWN);

    }
}