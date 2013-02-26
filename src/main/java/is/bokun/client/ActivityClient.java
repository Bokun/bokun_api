package is.bokun.client;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import is.bokun.dtos.activity.ActivityAvailabilityDto;
import is.bokun.dtos.activity.ActivityDto;
import is.bokun.dtos.search.SearchResultsDto;
import is.bokun.queries.ActivityQuery;
import org.codehaus.jackson.type.TypeReference;

import java.util.Date;
import java.util.List;

/**
 * Client for the Activity resource.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class ActivityClient extends AbstractClient {

    private static final String BASE = "/activity.json";

    /**
     * @see AbstractClient#()
     *
     * @param host
     * @param accessKey
     * @param secretKey
     * @param asyncClient
     */
    public ActivityClient(String host, String accessKey, String secretKey, AsyncHttpClient asyncClient) {
        super(host, accessKey, secretKey, asyncClient);
    }

    /**
     * Look up Activity by ID.
     *
     * @param activityId The ID of the Activity.
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the Activity with the ID supplied
     */
    public ActivityDto findById(Long activityId, String lang, String currency) {
        try {
            String uri = appendLangAndCurrency(BASE + "/" + activityId, lang, currency);
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), ActivityDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    /**
     * Look up Activity by slug. Note that slugs are not created automatically, they must
     * be defined per product in the Bokun extranet. Also note that the slugs are language
     * dependent.
     *
     * @param slug The slug to look up by.
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the Activity matching the slug and language provided
     */
    public ActivityDto findBySlug(String slug, String lang, String currency) {
        try {
            String uri = appendLangAndCurrency(BASE + "/slug/" + slug, lang, currency);
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), ActivityDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    /**
     * Perform a search for Activity. The ActivityQuery object has many ways of
     * constraining and ordering the results.
     *
     * @param query the query to be used
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return search results matching the query
     */
    public SearchResultsDto search(ActivityQuery query, String lang, String currency) {
        try {
            String uri = appendLangAndCurrency(BASE + "/search", lang, currency);
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.preparePost(host + uri);
            addSecurityHeaders(b, "POST", uri);
            b.setBodyEncoding("UTF-8");
            b.setBody(json.writeValueAsString(query));

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), SearchResultsDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    /**
     * Get the next upcoming availabilities (from today) for an Activity.
     *
     * @param activityId the ID of the Activity
     * @param maxResults the maximum number of results to be returned
     * @param includeSoldOut whether to include availabilities that are sold out
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return a list of the upcoming availabilities for the Accommodation
     */
    public List<ActivityAvailabilityDto> getUpcomingAvailabilities(Long activityId, int maxResults, boolean includeSoldOut, String lang, String currency) {
        try {
            String uri = appendLangAndCurrency(BASE + "/id/" + activityId + "/upcoming-availabilities/" + maxResults, lang, currency, new NVP("includeSoldOut", ""+includeSoldOut));
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), new TypeReference<List<ActivityAvailabilityDto>>(){});
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    /**
     * Get availabilities over a date range for an Activity.
     * Note that both the start and end dates MUST be supplied.
     *
     * @param activityId the ID of the Activity
     * @param start the start date of the range
     * @param end the end date of the range
     * @param includeSoldOut whether to include availabilities that are sold out
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return
     */
    public List<ActivityAvailabilityDto> getAvailabilitiesOnRange(Long activityId, Date start, Date end, boolean includeSoldOut, String lang, String currency) {
        try {
            String uri = appendLangAndCurrency(BASE + "/id/" + activityId + "/availabilities", lang, currency,
                    new NVP("start", Long.toString(start.getTime())), new NVP("end", Long.toString(end.getTime())),
                    new NVP("includeSoldOut", ""+includeSoldOut));

            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), new TypeReference<List<ActivityAvailabilityDto>>(){});
        } catch (Exception e) {
            throw wrapException(e);
        }
    }
}
