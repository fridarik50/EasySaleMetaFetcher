package eu.projects.fridarik.easysalemetafetcher.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReqResResponse {

    @SerializedName("data")
    private List<User> users;

    @SerializedName("page")
    private final int page;

    @SerializedName("total")
    private final int total;

    @SerializedName("total_pages")
    private final int totalPages;




    public ReqResResponse(List<User> users, int page, int total, int totalPages) {
        this.users = users;
        this.page = page;
        this.total = total;
        this.totalPages = totalPages;
    }

    public List<User> getUsers() {
        return users;
    }

    public int getPage() {
        return page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
