package com.core.isonsoft.xmlParsing;

import java.util.ArrayList;
import java.util.List;

/*
 * Stores an RSS feed
 */
public class Feed {

	final String title;
	final String link;
	final String description;
	final String language;
	final String copyright;
	final String pubDate;
	final String creator;
	final String category;
	final String content;
	final String encoded;

	public String getEncoded() {
		return encoded;
	}

	final List<FeedMessage> entries = new ArrayList<FeedMessage>();

	public Feed(String title, String link, String description, String language,
			String copyright, String pubDate, String creator, String category,
			String content, String encoded) {
		this.title = title;
		this.link = link;
		this.description = description;
		this.language = language;
		this.copyright = copyright;
		this.pubDate = pubDate;
		this.category = category;
		this.content = content;
		this.creator = creator;
		this.encoded = encoded;
	}

	public List<FeedMessage> getMessages() {
		return entries;
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getDescription() {
		return description;
	}

	public String getLanguage() {
		return language;
	}

	public String getCopyright() {
		return copyright;
	}

	public String getPubDate() {
		return pubDate;
	}

	public String getCreator() {
		return creator;
	}

	public String getCategory() {
		return category;
	}

	public String getContent() {
		return content;
	}

	public List<FeedMessage> getEntries() {
		return entries;
	}

	@Override
	public String toString() {
		return "Feed [copyright=" + copyright + ", description=" + description
				+ ", language=" + language + ", link=" + link + ", pubDate="
				+ pubDate + ", content=" + content + ", category=" + category
				+ ", creator=" + creator + ",encoded=" + encoded + ", title="
				+ title + "]";
	}

}
