package com.example.metric_time_app_android;

import android.util.Log;

import java.time.*;
import java.util.TimeZone;

public class FrenchRepublicanDate {
    static String[] monthNames = {"Vendémiaire","Brumaire", "Frimaire","Nivôse",
            "Pluviôse","Ventôse", "Germinal", "Floréal", "Prairial", "Messidor",
            "Thermidor", "Fructidor", "Sansculottides" };

    static String[] weekdayNames = {"Décadi", "Primidi", "Duodi", "Tridi", "Quartidi",
            "Quintidi", "Sextidi", "Septidi", "Octidi", "Nonidi"};

    static String[] dayNames = {"Raisin", "Safran", "Châtaigne", "Colchique", "Cheval", "Balsamine", "Carotte", "Amaranthe", "Panais", "Cuve",
            "Pomme de terre", "Immortelle", "Potiron", "Réséda", "Âne", "Belle de nuit", "Citrouille",  "Sarrasin", "Tournesol", "Pressoir",
            "Chanvre", "Pêche", "Navet", "Amaryllis","Bœuf",  "Aubergine", "Piment","Tomate","Orge", "Tonneau",
            "Pomme", "Céleri","Poire","Betterave", "Oie","Héliotrope", "Figue",  "Scorsonère", "Alisier",  "Charrue",
            "Salsifis","Mâcre","Topinambour", "Endive", "Dindon","Chervis", "Cresson", "Dentelaire", "Grenade","Herse",
            "Bacchante",  "Azerole", "Garance",  "Orange","Faisan", "Pistache",  "Macjonc",  "Coing",  "Cormier", "Rouleau",
            "Raiponce",  "Turneps","Chicorée", "Nèfle", "Cochon","Mâche", "Chou-fleur", "Miel","Genièvre","Pioche",
            "Cire", "Raifort",  "Cèdre",  "Sapin", "Chevreuil", "Ajonc","Cyprès","Lierre", "Sabine", "Hoyau",
            "Érable à sucre", "Bruyère", "Roseau", "Oseille","Grillon",  "Pignon", "Liège", "Truffe",  "Olive",  "Pelle",
            "Tourbe", "Houille", "Bitume",  "Soufre",  "Chien","Lave",  "Terre végétale", "Fumier",  "Salpêtre",  "Fléau",
            "Granit","Argile","Ardoise", "Grès",  "Lapin","Silex", "Marne", "Pierre à chaux", "Marbre",  "Van",
            "Pierre à plâtre", "Sel",  "Fer", "Cuivre", "Chat",  "Étain","Plomb", "Zinc", "Mercure","Crible",
            "Lauréole", "Mousse", "Fragon", "Perce-neige", "Taureau", "Laurier-thym", "Amadouvier", "Mézéréon", "Peuplier", "Coignée",
            "Ellébore","Brocoli","Laurier","Avelinier", "Vache",  "Buis", "Lichen", "If",  "Pulmonaire", "Serpette",
            "Thlaspi","Thimelé", "Chiendent",  "Trainasse",  "Lièvre",  "Guède","Noisetier",  "Cyclamen", "Chélidoine", "Traîneau",
            "Tussilage",  "Cornouiller", "Violier",  "Troène","Bouc",  "Asaret", "Alaterne", "Violette", "Marceau", "Bêche",
            "Narcisse", "Orme",  "Fumeterre", "Vélar", "Chèvre",  "Épinard",  "Doronic",  "Mouron",  "Cerfeuil",  "Cordeau",
            "Mandragore", "Persil", "Cochléaria",  "Pâquerette", "Thon","Pissenlit", "Sylvie", "Capillaire",  "Frêne", "Plantoir",
            "Primevère","Platane", "Asperge",  "Tulipe",  "Poule",  "Bette","Bouleau", "Jonquille",  "Aulne",  "Couvoir",
            "Pervenche","Charme", "Morille",  "Hêtre",  "Abeille", "Laitue", "Mélèze",  "Ciguë", "Radis", "Ruche",
            "Gainier",  "Romaine","Marronnier","Roquette",  "Pigeon", "Lilas",  "Anémone", "Pensée","Myrtille","Greffoir",
            "Rose","Chêne", "Fougère",  "Aubépine",  "Rossignol",  "Ancolie",  "Muguet", "Champignon", "Hyacinthe",  "Râteau",
            "Rhubarbe", "Sainfoin",  "Bâton d'or", "Chamerisier","Ver à soie", "Consoude", "Pimprenelle", "Corbeille d'or", "Arroche",  "Sarcloir",
            "Statice", "Fritillaire",  "Bourrache", "Valériane","Carpe",  "Fusain","Civette", "Buglosse",  "Sénevé", "Houlette",
            "Luzerne", "Hémérocalle","Trèfle","Angélique",  "Canard",  "Mélisse", "Fromental","Martagon", "Serpolet",  "Faux",
            "Fraise",  "Bétoine",  "Pois",  "Acacia",  "Caille", "Œillet",  "Sureau", "Pavot","Tilleul",  "Fourche",
            "Barbeau", "Camomille","Chèvrefeuille","Caille-lait", "Tanche", "Jasmin", "Verveine", "Thym", "Pivoine",  "Chariot",
            "Seigle", "Avoine",  "Oignon",  "Véronique",  "Mulet",  "Romarin",  "Concombre", "Échalote", "Absinthe",  "Faucille",
            "Coriandre","Artichaut", "Girofle","Lavande", "Chamois",  "Tabac",  "Groseille", "Gesse",  "Cerise", "Parc",
            "Menthe", "Cumin",  "Haricot",  "Orcanète", "Pintade",  "Sauge",  "Ail","Vesce",  "Blé",  "Chalémie",
            "Épeautre", "Bouillon blanc", "Melon", "Ivraie", "Bélier",  "Prêle",  "Armoise",  "Carthame",  "Mûre",  "Arrosoir",
            "Panic",  "Salicorne", "Abricot",  "Basilic", "Brebis", "Guimauve",  "Lin", "Amande", "Gentiane",  "Écluse",
            "Carline",  "Câprier",  "Lentille", "Aunée",  "Loutre", "Myrte",  "Colza",  "Lupin",  "Coton","Moulin",
            "Prune",  "Millet",  "Lycoperdon",  "Escourgeon", "Saumon",  "Tubéreuse",  "Sucrion",  "Apocyn",  "Réglisse",  "Échelle",
            "Pastèque", "Fenouil", "Épine vinette",  "Noix","Truite", "Citron","Cardère", "Nerprun",  "Tagette",  "Hotte",
            "Églantier", "Noisette", "Houblon",  "Sorgho", "Écrevisse",  "Bigarade", "Verge d'or",  "Maïs", "Marron", "Panier",
            "la Vertu", "Génie", "Travail", "l'Opinion", "Récompenses",  "la Révolution"};
    boolean isLeapYear;
    private int currentDay;
    private int currentMonth;
    private int currentYear;
    private int currentDayInYear;



    public FrenchRepublicanDate(LocalDate currentDate) {
        LocalDate frenchEpoch = LocalDate.of(1792, Month.SEPTEMBER, 22);
        LocalDate current = LocalDate.now();
        int days = (int) (currentDate.toEpochDay() - frenchEpoch.toEpochDay());
        //this.days = (int) Math.floor((double) adjustedMilliseconds / millisecondsInDay);
        int unadjustedYears = (int) Math.floor( (double) days / 365);
        int leapYears = getLeapYears(unadjustedYears+1);
        int yesterdayLeapYears = getLeapYears(unadjustedYears);
        int years = (int) Math.floor((double) (days - (leapYears-1)) /365);
        years = years + 1;
        this.isLeapYear = isLeap(years);


        int yeardays = ((days) - (leapYears-1)) % 365;

        if(isLeapYear) {
            yeardays++;
        }

        this.currentDay = (yeardays % 30)+1;
        this.currentMonth = (int) Math.floor((double) yeardays / 30);
        this.currentYear = years;
        this.currentDayInYear = yeardays;


    }

    public FrenchRepublicanDate(int year, int month, int day) {
        this.currentYear = year;
        this.currentMonth = month;
        this.currentDay = day;
        this.currentDayInYear = (((month) * 30)+day)-1;
        this.isLeapYear = isLeap(year);

    }
    private static int getLeapYears(int year) {
        int leapYears = 3;
        for (int i =12; i<=year; i++) {
            if (isLeap(i)) {
                leapYears += 1;
            }
        }
        return leapYears;
    }

    public static boolean isLeap(int year) {
        return  (year % 4 == 0 & year % 100 != 0 & year % 400 != 0 & year % 4000 != 0);
    }

    public static FrenchRepublicanDate of(int year, int month, int day) {
        return new FrenchRepublicanDate(year, month, day);
    }

    public int getDay() {
        return currentDay;
    }

    public int getYear() {
        return currentYear;
    }

    public int getMonth() {
        return currentMonth;
    }

    public int getDayInYear() {
        return currentDayInYear;
    }

    public int getDecade() {
        return (int) Math.floor((double) (this.getDayInYear()) / 10)+1;
    }

    public String getWeekName() {
        int date = getDay();
        return weekdayNames[date % 10];
    }

    public static String getMonthName(int i) {
        return monthNames[i];
    }

    public String getMonthName() {
        return monthNames[getMonth()];
    }

    public String getDayName() {
        return dayNames[this.getDayInYear()];
    }

    public String getFormattedDate() {
        return getWeekName() + " (" + getDayName() + ") " + getDay() + " " + getMonthName() + " " + getYear() + " décade " + getDecade();
    }


    public FrenchRepublicanDate minusMonth() {
        if(this.currentMonth > 0) {
            this.currentMonth -= 1;
            this.currentDayInYear -= 30;
        } else {
            this.currentMonth = 12;
            this.currentYear -= 1;
            this.currentDayInYear = 364;
            this.currentDay = 5;
            this.isLeapYear = isLeap(this.currentYear);
        }
        return this;
    }

    public FrenchRepublicanDate plusMonth() {
        if(this.currentMonth <12) {
            this.currentMonth += 1;
            //this.currentDayInYear += 30;
        } else {
            this.currentMonth = 0;
            this.currentYear += 1;
            this.currentDayInYear = 0;
            this.currentDay = 1;
            this.isLeapYear = isLeap(this.currentYear);
        }
        return this;
    }

    public void addOneDay() {
        if (currentMonth <12) {
            if (currentDay < 30) {
                currentDay += 1;

            } else {
                currentDay = 1;
                currentMonth += 1;
            }
            currentDayInYear += 1;
        } else {
            if (currentDay < 6) {
                currentDay += 1;
                currentDayInYear += 1;
            } else {
                currentMonth = 0;
                currentYear += 1;
                currentDayInYear = 0;
                currentDay = 1;
                isLeapYear = isLeap(currentYear);
            }
        }

    }

    public void subOneDay() {
        if(this.currentMonth > 0) {
            if (this.currentDay > 1) {
                this.currentDay -= 1;
                this.currentDayInYear -= 1;
            } else {
                this.currentMonth -= 1;
                this.currentDay = 30;
                this.currentDayInYear -= 1;
            }
        } else {
            if (currentDay > 1) {
                currentDay -= 1;
                currentDayInYear -= 1;
            } else {
                this.currentYear -= 1;
                this.isLeapYear = isLeap(this.currentYear);
                this.currentMonth = 12;
                if(this.isLeapYear) {
                    this.currentDay = 6;
                    this.currentDayInYear = 365;
                } else {
                    this.currentDay = 5;
                    this.currentDayInYear = 364;
                }

            }
        }

    }

    public FrenchRepublicanDate plusDays(int i) {
        FrenchRepublicanDate newDate = of(this.currentYear, this.currentMonth, this.currentDay);
        for(int j = 1; j <= i; j++) {
            newDate.addOneDay();
        }
        return newDate;
    }

    public FrenchRepublicanDate minusDays(int i) {
        FrenchRepublicanDate newDate = of(this.currentYear, this.currentMonth, this.currentDay);
        for(int j = 1; j <= i; j++) {
            newDate.subOneDay();
            //Log.d("tag", String.valueOf(this.getDay()));
        }
        return newDate;
    }

    public boolean isBefore(FrenchRepublicanDate date) {
        int thisDays;
        int dateDays;

        thisDays = currentDay;
        thisDays += (currentMonth) * 30;
        thisDays += (currentYear) * 12 * 30;



        dateDays = date.currentDay;
        dateDays += (date.currentMonth) * 30;
        dateDays += (date.currentYear) * 12 * 30;

        Log.d("TAG", String.valueOf(thisDays));
        Log.d("TAG", String.valueOf(dateDays));
        return thisDays < dateDays;

    }

    public boolean isAfter(FrenchRepublicanDate date) {
        int thisDays;
        int dateDays;

        thisDays = this.currentDay;
        thisDays += (this.currentMonth-1) * 30;
        thisDays += (this.currentYear-1) * 12 * 30;

        dateDays = date.currentDay;
        dateDays += (date.currentMonth-1) * 30;
        dateDays += (date.currentYear-1) * 12 * 30;

        return thisDays > dateDays;
    }

    public boolean approxEquals(FrenchRepublicanDate date) {
        if(this.getYear() == date.getYear() & this.getMonth() == date.getMonth() & this.getDay() == date.getDay()) {
            return true;
        }
        return false;
    }

    public int getDaysInMonth() {
        if (this.getMonth() == 12) {
            if(!this.isLeapYear) {
                return 5;
            } else {
                return 6;
            }
        } else {
            return 30;
        }
    }
}
