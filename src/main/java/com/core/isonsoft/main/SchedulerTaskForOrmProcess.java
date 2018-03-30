package com.core.isonsoft.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.core.isonsoft.beans.CodeDataSourceBean;
import com.core.isonsoft.parsingJson.storeToDb.AllCoinDepthFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.AllCoinTradesFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.BitStampEurUsdFeedToDb;
import com.core.isonsoft.parsingJson.storeToDb.BitStampOrderBookFeedToDb;
import com.core.isonsoft.parsingJson.storeToDb.BitStampTickerFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.BitStampTickerHourFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.BitStampTransactionsFeedToDb;
import com.core.isonsoft.parsingJson.storeToDb.BitStockOrderFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.BitTrexGetCurrenciesFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.BitTrexGetMarketHistoryFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.BitTrexGetMarketSummariesFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.BitTrexGetMarketsFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.BitTrexGetTickerFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.BtceDeptFeedToDb;
import com.core.isonsoft.parsingJson.storeToDb.BtceTickerFeedToDb;
import com.core.isonsoft.parsingJson.storeToDb.BtceTradeFeedToDb;
import com.core.isonsoft.parsingJson.storeToDb.CcexCoinNamesFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.CcexDashBtcFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.CcexGetBalanceDistributionFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.CcexGetMarketHistoryFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.CcexGetMarketSFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.CcexOrderBookFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.CcexPairsFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.CcexPricesFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.CcexVolumeBtcFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.CoinDeskCurrentPrice;
import com.core.isonsoft.parsingJson.storeToDb.CoinMarketCapGlobalFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.CoinMarketCapTickerBeanFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.CryptoCoinsNewsFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.EconomistIndexFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.StagAllCoinSticker;
import com.core.isonsoft.parsingJson.storeToDb.StagBitTrexGetOrderBookFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.StagCcgetMrktSumryJsonParsing;
import com.core.isonsoft.parsingJson.storeToDb.VirCurExCurrencyFeedToDb;
import com.core.isonsoft.parsingJson.storeToDb.VirCurExVolume;
import com.core.isonsoft.parsingJson.storeToDb.VircurExTradesFeedToDB;
import com.core.isonsoft.parsingJson.storeToDb.VircurexOrderBookFeedToDb;
import com.core.isonsoft.xmlParsing.HibernateUtil;

public class SchedulerTaskForOrmProcess extends TimerTask {
	private static final Logger LOG = LoggerFactory
			.getLogger(SchedulerTaskForOrmProcess.class);

	@Override
	public void run() {

	}

	public static void main(String[] args) throws JSONException, SQLException,
			IOException, InterruptedException {

		Timer timer = new Timer();
		int intervaltime = Integer.parseInt("60");
		parseAndStoreDataToDB();
		callTheSchedulerTask(intervaltime, timer);

	}

	private static void callTheSchedulerTask(int intervaltime, Timer timer)
			throws InterruptedException {
		for (int i = 10; i < 51; i++) {
			switch (String.valueOf(i)) {
			case "10":
				LOG.info("into ID 10 ");
				CoinDeskCurrentPrice scfj = new CoinDeskCurrentPrice();
				timer.scheduleAtFixedRate(scfj, 0, intervaltime * 60 * 1000);
				break;

			case "11":

				EconomistIndexFeedToDB scfj111 = new EconomistIndexFeedToDB();
				timer.scheduleAtFixedRate(scfj111, 0, intervaltime * 60 * 1000);
				LOG.info("--11-END of ---");
				break;
			case "12":
				/*
				 * BitCoinMagazinFeedToDB scfj12=new BitCoinMagazinFeedToDB();
				 * timer.scheduleAtFixedRate(scfj12, 0, intervaltime*60*1000);
				 * LOG.info("--12-END of ---");
				 */
				break;
			case "13":
				CryptoCoinsNewsFeedToDB scfj13 = new CryptoCoinsNewsFeedToDB();
				timer.scheduleAtFixedRate(scfj13, 0, intervaltime * 60 * 1000);
				LOG.info("--13-END of ---");
				break;
			case "14":

				VircurExTradesFeedToDB scfj14 = new VircurExTradesFeedToDB();
				timer.scheduleAtFixedRate(scfj14, 0, intervaltime * 60 * 1000);
				LOG.info("--14-END of ---");
				break;
			case "15":

				VircurexOrderBookFeedToDb scfj15 = new VircurexOrderBookFeedToDb();
				timer.scheduleAtFixedRate(scfj15, 0, intervaltime * 60 * 1000);
				LOG.info("--15-END of ---");
				break;
			case "16":

				VirCurExVolume scfj16 = new VirCurExVolume();
				timer.scheduleAtFixedRate(scfj16, 0, intervaltime * 60 * 1000);
				LOG.info("--16-END of ---");
				break;
			case "17":

				VirCurExCurrencyFeedToDb scfj17 = new VirCurExCurrencyFeedToDb();
				timer.scheduleAtFixedRate(scfj17, 0, intervaltime * 60 * 1000);
				LOG.info("-17--END of ---");
				break;
			case "18":

				LOG.info("***********NODATA******");
				LOG.info("-18--END of ---");
				break;
			case "19":

				LOG.info("***********NODATA******");
				LOG.info("--19-END of ---");
				break;
			case "20":

				BtceDeptFeedToDb scfj20 = new BtceDeptFeedToDb();
				timer.scheduleAtFixedRate(scfj20, 0, intervaltime * 60 * 1000);
				LOG.info("-20--END of ---");
				break;
			case "21":

				BtceTradeFeedToDb scfj21 = new BtceTradeFeedToDb();
				timer.scheduleAtFixedRate(scfj21, 0, intervaltime * 60 * 1000);
				LOG.info("--21-END of ---");
				break;
			case "22":

				BtceTickerFeedToDb scfj22 = new BtceTickerFeedToDb();
				timer.scheduleAtFixedRate(scfj22, 0, intervaltime * 60 * 1000);
				LOG.info("-22-END of ---");
				break;
			case "23":

				/*
				 * SchedulerForId23 scfj23=new SchedulerForId23();
				 * timer.scheduleAtFixedRate(scfj23, 0, intervaltime*60*1000);
				 * LOG.info("--23-END of ---");
				 */
				break;
			case "24":

				BitStampEurUsdFeedToDb scfj24 = new BitStampEurUsdFeedToDb();
				timer.scheduleAtFixedRate(scfj24, 0, intervaltime * 60 * 1000);
				LOG.info("--24-END of ---");
				break;
			case "25":

				BitStampTransactionsFeedToDb scfj25 = new BitStampTransactionsFeedToDb();
				timer.scheduleAtFixedRate(scfj25, 0, intervaltime * 60 * 1000);
				LOG.info("--25-END of ---");
				break;
			case "26":

				BitStampOrderBookFeedToDb scfj26 = new BitStampOrderBookFeedToDb();
				timer.scheduleAtFixedRate(scfj26, 0, intervaltime * 60 * 1000);
				LOG.info("--26-END of ---");
				break;
			case "27":

				BitStampTickerFeedToDB scfj27 = new BitStampTickerFeedToDB();
				timer.scheduleAtFixedRate(scfj27, 0, intervaltime * 60 * 1000);
				LOG.info("-27--END of ---");
				break;
			case "28":

				BitStampTickerHourFeedToDB scfj28 = new BitStampTickerHourFeedToDB();
				timer.scheduleAtFixedRate(scfj28, 0, intervaltime * 60 * 1000);
				LOG.info("--28-END of ---");
				break;
			case "29":

				BitTrexGetCurrenciesFeedToDB scfj29 = new BitTrexGetCurrenciesFeedToDB();
				timer.scheduleAtFixedRate(scfj29, 0, intervaltime * 60 * 1000);
				LOG.info("--29-END of ---");
				break;
			case "30":

				BitTrexGetMarketsFeedToDB scfj30 = new BitTrexGetMarketsFeedToDB();
				timer.scheduleAtFixedRate(scfj30, 0, intervaltime * 60 * 1000);
				LOG.info("-30--END of ---");
				break;
			case "31":

				BitTrexGetTickerFeedToDB scfj31 = new BitTrexGetTickerFeedToDB();
				timer.scheduleAtFixedRate(scfj31, 0, intervaltime * 60 * 1000);
				LOG.info("--31-END of ---");
				break;
			case "32":
				BitTrexGetMarketSummariesFeedToDB scfj32 = new BitTrexGetMarketSummariesFeedToDB();
				timer.scheduleAtFixedRate(scfj32, 0, intervaltime * 60 * 1000);
				LOG.info("--32-END of ---");
				break;
			case "33":

				StagBitTrexGetOrderBookFeedToDB scfj33 = new StagBitTrexGetOrderBookFeedToDB();
				timer.scheduleAtFixedRate(scfj33, 0, intervaltime * 60 * 1000);
				LOG.info("--33-END of ---");
				break;
			case "34":

				BitTrexGetMarketHistoryFeedToDB scfj34 = new BitTrexGetMarketHistoryFeedToDB();
				timer.scheduleAtFixedRate(scfj34, 0, intervaltime * 60 * 1000);
				LOG.info("-34--END of ---");
				break;
			case "35":

				AllCoinDepthFeedToDB scfj35 = new AllCoinDepthFeedToDB();
				timer.scheduleAtFixedRate(scfj35, 0, intervaltime * 60 * 1000);
				LOG.info("--35-END of ---");
				break;
			case "36":

				StagAllCoinSticker scfj36 = new StagAllCoinSticker();
				timer.scheduleAtFixedRate(scfj36, 0, intervaltime * 60 * 1000);
				LOG.info("--36-END of ---");
				break;
			case "37":

				AllCoinTradesFeedToDB scfj37 = new AllCoinTradesFeedToDB();
				timer.scheduleAtFixedRate(scfj37, 0, intervaltime * 60 * 1000);
				LOG.info("--37-END of ---");
				break;
			case "38":

				CcexDashBtcFeedToDB scfj38 = new CcexDashBtcFeedToDB();
				timer.scheduleAtFixedRate(scfj38, 0, intervaltime * 60 * 1000);
				LOG.info("--38-END of ---");
				break;
			case "39":

				CcexPairsFeedToDB scfj39 = new CcexPairsFeedToDB();
				timer.scheduleAtFixedRate(scfj39, 0, intervaltime * 60 * 1000);
				LOG.info("-39--END of ---");
				break;
			case "40":

				CcexPricesFeedToDB scfj40 = new CcexPricesFeedToDB();
				timer.scheduleAtFixedRate(scfj40, 0, intervaltime * 60 * 1000);
				LOG.info("-40--END of ---");
				break;
			case "41":

				CcexCoinNamesFeedToDB scfj41 = new CcexCoinNamesFeedToDB();
				timer.scheduleAtFixedRate(scfj41, 0, intervaltime * 60 * 1000);
				LOG.info("-41--END of ---");
				break;
			case "42":

				CcexVolumeBtcFeedToDB scfj42 = new CcexVolumeBtcFeedToDB();
				timer.scheduleAtFixedRate(scfj42, 0, intervaltime * 60 * 1000);
				LOG.info("-42--END of ---");
				break;
			case "43":

				CcexGetMarketSFeedToDB scfj43 = new CcexGetMarketSFeedToDB();
				timer.scheduleAtFixedRate(scfj43, 0, intervaltime * 60 * 1000);
				LOG.info("-43--END of ---");
				break;
			case "44":

				CcexOrderBookFeedToDB scfj44 = new CcexOrderBookFeedToDB();
				timer.scheduleAtFixedRate(scfj44, 0, intervaltime * 60 * 1000);
				LOG.info("-44--END of ---");
				break;
			case "45":

				StagCcgetMrktSumryJsonParsing scfj45 = new StagCcgetMrktSumryJsonParsing();
				timer.scheduleAtFixedRate(scfj45, 0, intervaltime * 60 * 1000);
				LOG.info("--46-END of ---");
				break;
			case "46":

				CcexGetMarketHistoryFeedToDB scfj46 = new CcexGetMarketHistoryFeedToDB();
				timer.scheduleAtFixedRate(scfj46, 0, intervaltime * 60 * 1000);
				LOG.info("--46-END of ---");
				break;
			case "47":

				CcexGetBalanceDistributionFeedToDB scfj47 = new CcexGetBalanceDistributionFeedToDB();
				timer.scheduleAtFixedRate(scfj47, 0, intervaltime * 60 * 1000);
				LOG.info("-47--END of ---");
				break;
			case "48":

				BitStockOrderFeedToDB scfj48 = new BitStockOrderFeedToDB();
				timer.scheduleAtFixedRate(scfj48, 0, intervaltime * 60 * 1000);
				LOG.info("-48--END of ---");
				break;
			case "49":

				CoinMarketCapGlobalFeedToDB scfj49 = new CoinMarketCapGlobalFeedToDB();
				timer.scheduleAtFixedRate(scfj49, 0, intervaltime * 60 * 1000);
				LOG.info("-49--END of ---");
				break;
			case "50":

				CoinMarketCapTickerBeanFeedToDB scfj50 = new CoinMarketCapTickerBeanFeedToDB();
				timer.scheduleAtFixedRate(scfj50, 0, intervaltime * 60 * 1000);
				LOG.info("-50--END of ---");
				break;

			case "last":

				/*
				 * ResultSetWriteInToTextFile scfjlast=new
				 * ResultSetWriteInToTextFile();
				 * timer.scheduleAtFixedRate(scfjlast, 0, intervaltime*60*1000);
				 * LOG.info("-last--END of ---");
				 */
				break;

			default:
				break;
			}
			Thread.sleep(15555);
		}

	}

	@SuppressWarnings("resource")
	public static void parseAndStoreDataToDB() throws IOException {
		Session session = null;
		FileInputStream file = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			file = new FileInputStream(
					new File(
							"src/main/filesPath/datasourceXls/Virtual_Datasources.xlsx"));
			// Create Workbook instance holding reference to .xlsx file
			// HSSFWorkbook myWorkBook = new HSSFWorkbook(new
			// POIFSFileSystem(new
			// FileInputStream("C:\\Users\\raghu\\Desktop\\in\\Virtual_Datasources.xls")));
			session.beginTransaction();
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				try {
					CodeDataSourceBean code = new CodeDataSourceBean();
					code.setId((int) (row.getCell(0).getNumericCellValue()));
					code.setUrl(row.getCell(1).getStringCellValue());
					code.setStaggingTables(row.getCell(2).getStringCellValue());
					code.setSecondaryTables(row.getCell(3).getStringCellValue());
					session.saveOrUpdate(code);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			session.flush();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			file.close();
			session.close();
		}
	}

}
