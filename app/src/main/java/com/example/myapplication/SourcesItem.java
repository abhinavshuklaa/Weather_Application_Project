package com.example.myapplication;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SourcesItem implements Serializable {

	@SerializedName("title")
	private String title;

	@SerializedName("slug")
	private String slug;

	@SerializedName("url")
	private String url;

	@SerializedName("crawl_rate")
	private int crawlRate;

	public String getTitle(){
		return title;
	}

	public String getSlug(){
		return slug;
	}

	public String getUrl(){
		return url;
	}

	public int getCrawlRate(){
		return crawlRate;
	}
}