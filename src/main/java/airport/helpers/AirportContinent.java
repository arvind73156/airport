package airport.helpers;

/**
 * The enum Airport continents.
 * @author Arvind
 */
public enum AirportContinent {
    /**
     * As airport continents.
     */
    AS("Asia"),
    /**
     * Af airport continents.
     */
    AF("Africa"),
    /**
     * The Na.
     */
    NA("North America"),
    /**
     * An airport continents.
     */
    AN("Antarctica"),
    /**
     * Eu airport continents.
     */
    EU("Europe"),
    /**
     * Oc airport continents.
     */
    OC("Oceania"),
    /**
     * Sa airport continents.
     */
    SA("South_America");

    /**
     * The Continent.
     */
    String continent;
    AirportContinent(String continent){
        this.continent=continent;
    }

    /**
     * Get enum by string string.
     *
     * @param continentName the continent name
     * @return the string
     */
    public static String getEnumByString(String continentName){
        for(AirportContinent e : AirportContinent.values()){
            if(e.continent.equals(continentName)) return e.name();
        }
        return null;
    }
}
