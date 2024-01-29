package com.example.metric_time_app_android;

import android.util.Log;

import java.time.*;
import java.util.TimeZone;

public class FrenchRepublicanDate {
    long millisecondsInDay = 86400000;
    long leapYearAmount = 20925216;
    long equinoxStart = 34284216;
    int days;
    int yesterdays;
    boolean isLeapYear;
    int unadjustedYears;
    int leapYears;
    int yesterdayLeapYears;
    int years;
    int yeardays;

    int currentDay;
    int currentMonth;
    int currentYear;

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

    public FrenchRepublicanDate(LocalDateTime currentDateTime) {
        LocalDateTime frenchRepEpoch = LocalDateTime.of(1792, Month.SEPTEMBER, 22, 0, 0);
        ZoneId localTimeZone = ZoneId.systemDefault();
        ZoneOffset localOffset = localTimeZone.getRules().getOffset(currentDateTime);
        long adjustedMilliseconds = ((currentDateTime.toEpochSecond(localOffset) - frenchRepEpoch.toEpochSecond(localOffset)) * 1000);
        this.days = (int) Math.floor((double) adjustedMilliseconds / millisecondsInDay);
        this.yesterdays = days-1;
        this.isLeapYear = false;
        this.unadjustedYears = (int) Math.floor( (double) days / 365);
        this.leapYears = (int) Math.floor((double) ((leapYearAmount * unadjustedYears) + equinoxStart) / millisecondsInDay);
        this.yesterdayLeapYears  = (int) Math.floor((double) ((leapYearAmount * (unadjustedYears-1)) + equinoxStart) / millisecondsInDay);

        //this.yesterdayLeapYears = (int) Math.floor(((leapYearAmount * Math.floor((double) yesterdays / 365)) + equinoxStart)/ millisecondsInDay);

        this.years = (int) Math.floor((double) (days - leapYears) /365);

        if(yesterdayLeapYears != leapYears) {
            this.isLeapYear = true;
        }

        this.yeardays = (days - leapYears) % 365;

        if(isLeapYear) {
            this.yeardays++;
        }

        this.currentDay = (yeardays % 30)+1;
        this.currentMonth = (int) Math.floor((double) this.yeardays / 30);
        this.currentYear = (++years);
    }

    public static FrenchRepublicanDate of(int year, int month, int day) {
        FrenchRepublicanDate date = new FrenchRepublicanDate(LocalDateTime.now());
        date.currentDay = day;
        date.currentMonth = month;
        date.currentYear = year;

        return date;
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

    public int getDecade() {
        return (int) Math.floor((double) this.yeardays / 10) + 1;
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
        return dayNames[this.yeardays];
    }

    public String getFormattedDate() {
        return getWeekName() + " (" + getDayName() + ") " + getDay() + " " + getMonthName() + " " + getYear() + " décade " + getDecade();
    }


    public FrenchRepublicanDate minusMonths(int months) {
        if(this.currentMonth > 0) {
            this.currentMonth -= 1;
        } else {
            this.currentMonth = 12;
            this.currentYear -= 1;
        }
        return this;
    }

    public FrenchRepublicanDate plusMonths(int months) {
        if(this.currentMonth <12) {
            this.currentMonth += 1;
        } else {
            this.currentMonth = 0;
            this.currentYear += 1;
        }
        return this;
    }

    public void addOneDay() {
        if (currentDay == 30) {
            currentDay = 1;
            if(currentMonth <12) {
                currentMonth += 1;
            } else {
                currentMonth = 0;
                currentYear += 1;
            }
        } else {
            currentDay += 1;
        }
    }

    public void subOneDay() {
        if (currentDay == 1) {
            currentDay = 30;
            if(currentMonth >0) {
                currentMonth -= 1;
            } else {
                currentMonth = 12;
                currentYear -= 1;
            }
        } else {
            currentDay -= 1;
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

        thisDays = this.currentDay;
        thisDays += (this.currentMonth-1) * 30;
        thisDays += (this.currentYear-1) * 12 * 30;

        dateDays = date.currentDay;
        dateDays += (date.currentMonth-1) * 30;
        dateDays += (date.currentYear-1) * 12 * 30;

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
