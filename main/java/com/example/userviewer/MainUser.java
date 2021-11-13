package com.example.userviewer;

import java.util.ArrayList;

public class MainUser {
private String page = "page";
    private String perPage = "per_page";
    private String total = "total";
    private String totalPages = "total_pages";
    private ArrayList<MainData> mainData;
    private String perSupport = "support";

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPerPage() {
        return perPage;
    }

    public void setPerPage(String perPage) {
        this.perPage = perPage;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    public ArrayList<MainData> getMainData() {
        return mainData;
    }

    public void setMainData(ArrayList<MainData> mainData) {
        this.mainData = mainData;
    }
}
