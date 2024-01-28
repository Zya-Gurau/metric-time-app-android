package com.example.metric_time_app_android;

import java.time.*;
import java.util.TimeZone;

public class FrenchRepublicanDate {
    LocalDateTime currentDateTime = LocalDateTime.now();
    LocalDateTime frenchRepEpoch = LocalDateTime.of(1792, Month.SEPTEMBER, 22, 0, 0);
    ZoneId localTimeZone = ZoneId.systemDefault();
    ZoneOffset localOffset = localTimeZone.getRules().getOffset(currentDateTime);
    long adjustedMilliseconds = ((currentDateTime.toEpochSecond(localOffset) - frenchRepEpoch.toEpochSecond(localOffset)) * 1000);
    long millisecondsInDay = 86400000;
    long leapYearAmount = 20925216;
    long equinoxStart = 34284216;
    int days;
    int yesterdays;
    boolean isLeapDay;
    int unadjustedYears;
    int leapYears;
    int yesterdayLeapYears;
    int years;
    int yeardays;

    String[] monthNames = {"Vendémiaire","Brumaire", "Frimaire","Nivôse",
            "Pluviôse","Ventôse", "Germinal", "Floréal", "Prairial", "Messidor",
            "Thermidor", "Fructidor", "Sansculottides" };

    String[] weekdayNames = {"Décadi", "Primidi", "Duodi", "Tridi", "Quartidi",
            "Quintidi", "Sextidi", "Septidi", "Octidi", "Nonidi"};

    String[] dayNames = {"Raisin", "Safran", "Châtaigne", "Colchique", "Cheval", "Balsamine", "Carotte", "Amaranthe", "Panais", "Cuve",
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

    public FrenchRepublicanDate() {
        this.days = (int) Math.floor((double) adjustedMilliseconds / millisecondsInDay);
        this.yesterdays = days-1;
        this.isLeapDay = false;
        this.unadjustedYears = (int) Math.floor( (double) days / 365);
        this.leapYears = (int) Math.floor((double) ((leapYearAmount * unadjustedYears) + equinoxStart) / millisecondsInDay);
        this.yesterdayLeapYears = (int) Math.floor(((leapYearAmount * Math.floor((double) yesterdays / 365)) + equinoxStart)/ millisecondsInDay);

        this.years = (int) Math.floor((double) (days - leapYears) /365);

        if(yesterdayLeapYears != leapYears) {
            this.isLeapDay = true;
        }

        this.yeardays = (days - leapYears) % 365;

        if(isLeapDay) {
            this.yeardays++;
        }
    }

    public int getDay() {
        int date = yeardays % 30;
        date++;
        return date;
    }

    public int getYear() {
        this.years++;
        return this.years;
    }

    public int getMonth() {

        return (int) Math.floor((double) this.yeardays / 30);
    }

    public int getDecade() {
        return (int) Math.floor((double) this.yeardays / 10) + 1;
    }

    public String getWeekName() {
        int date = getDay();
        return weekdayNames[date % 10];
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





}
