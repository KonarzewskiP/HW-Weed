package weedData;

import java.util.stream.Stream;

public enum States {
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
    UNKNOW("Unkown");


    private String name;

    States(String name) {
        this.name = name;
    }

    public static String stateAsString(States statesName){
        String s = Stream.of(values())
                .filter(states -> states.equals(statesName))
                .map(states -> states.name)
                .findAny()
                .orElse(States.UNKNOW.name);
        return s;
    }

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
        States states1 = Stream.of(values())
                .filter(states -> states.name.equals(stateName))
                .findAny()
                .orElse(States.UNKNOW);
        return states1;

    }
}