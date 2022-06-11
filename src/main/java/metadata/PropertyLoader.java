package metadata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class reads all the property values and rearrange data accordingly
 *
 * @author Gayathri Gamage
 * Date 11 June 2022
 */
public class PropertyLoader {
    private static Properties allProperties;

    /**
     * This method reads all the property
     *
     * @throws IOException when errors occur while accessing the property files
     */
    public static void readProperties() throws IOException {
        allProperties = new Properties();
        /* *** Loads Property File *** */
        allProperties.load(new FileInputStream("src/main/resources/properties/EndPoints.properties"));
        createSearchEndPoint();

    }

    /**
     * This method creates the search end point by appending values located in the property file
     */
    private static void createSearchEndPoint() {
        /* *** Appends subsections to create the end point  *** */
        String categorySearchEndPoint = allProperties.getProperty(Constants.CATEGORY_SEARCH_IP) + allProperties.getProperty(Constants.CATEGORY_SEARCH_RESOURCE) + allProperties.getProperty(Constants.CATEGORY_SEARCH_QUERY_PARAMS);
        allProperties.put(Constants.CATEGORY_SEARCH_END_POINT, categorySearchEndPoint);

    }

    /**
     * This method is used to access property values
     *
     * @return Property object
     */
    public static Properties getAllProperties() {
        return allProperties;
    }


}
