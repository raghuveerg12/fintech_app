package com.web.isonsoft.helper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.core.isonsoft.beans.StagCryptoCoinsNewsFeedBeans;
import com.core.isonsoft.beans.StagEconomistIndexBean;
import com.core.isonsoft.xmlParsing.Feed;
import com.core.isonsoft.xmlParsing.FeedMessage;
import com.core.isonsoft.xmlParsing.RSSFeedParser;


public class RssFeedHelper {

	@SuppressWarnings("deprecation")
	public static List<Object>  convertRssFeedToList(Object paramValue,String path){
		
		List<Object> list=new ArrayList<Object>();
		RSSFeedParser parser = new RSSFeedParser(path);
		Feed feed = parser.readFeed();
		
		for (FeedMessage message : feed.getMessages()) {
			if(paramValue instanceof StagEconomistIndexBean ){
				((StagEconomistIndexBean) paramValue).setCreator(message.creator);
				((StagEconomistIndexBean) paramValue).setCategory(message.category);
				((StagEconomistIndexBean) paramValue).setDescription(message.description);
				((StagEconomistIndexBean) paramValue).setUpdated(new Timestamp(new Date(
					message.pubDate).getTime()));
				((StagEconomistIndexBean) paramValue).setLink(message.link);
				((StagEconomistIndexBean) paramValue).setTitle(message.title);
			}
			
			else if(paramValue instanceof StagCryptoCoinsNewsFeedBeans){
				
				((StagCryptoCoinsNewsFeedBeans) paramValue).setCreator(message.creator);
				((StagCryptoCoinsNewsFeedBeans) paramValue).setCategory(message.category);
				((StagCryptoCoinsNewsFeedBeans) paramValue).setDescription(message.description);
				((StagCryptoCoinsNewsFeedBeans) paramValue).setUpdated(new Timestamp(new Date(
					message.pubDate).getTime()));
				((StagCryptoCoinsNewsFeedBeans) paramValue).setLink(message.link);
				((StagCryptoCoinsNewsFeedBeans) paramValue).setTitle(message.title);
			}
			list.add(paramValue);
		}
		
		return list;
	}
}
