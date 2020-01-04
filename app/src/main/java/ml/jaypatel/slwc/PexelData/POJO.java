
package ml.jaypatel.slwc.PexelData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
public class POJO {

    @SerializedName("total_results")
    @Expose
    private int totalResults;
    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("per_page")
    @Expose
    private int perPage;
    @SerializedName("photos")
    @Expose
    private List<Photo> photos = null;
    @SerializedName("next_page")
    @Expose
    private String nextPage;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

}
