package task2;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

public class Electricity {

    public static void main(String[] args) throws IOException {

        class Data {
            String date;
            Integer actual = 0;
            Integer forecast = 0;
            }

        Document document = Jsoup.connect("http://www.mercado.ren.pt/EN/Electr/MarketInfo/Interconnections/CapForecast/Pages/Daily.aspx").get();
        Elements dates = document.select(".gridAll .tabHEADER th");
        
        Data[] matrix = new Data[dates.size() - 1]; {
            for (int i = 1; i < dates.size(); ++i) {
                matrix[i - 1] = new Data();
                matrix[i - 1].date = dates.get(i).ownText();
            }

            for (int hour = 1; hour <= 24; ++hour) {
                Elements row = document.select(".gridAll tr:nth-child(" + (hour + 2) + ") td");
                    for (int i = 1; i < row.size(); ++i) {
                        String aClass = row.get(i).attr("class");

                        if ("txtrVERIF".equals(aClass) || "txtVERIF".equals(aClass)) {
                            matrix[i - 1].actual += Integer.parseInt(row.get(i).ownText());
                        } else if("txtrPREV".equals(aClass) || "txtPREV".equals(aClass)) {
                                  matrix[i - 1].forecast += Integer.parseInt(row.get(i).ownText());
                            }
                    }
            }

            System.out.println("Date,Actual,Forecast");
            for (Data data : matrix) {
                System.out.println(data.date + "," + data.actual + "," + data.forecast);
            }
        }
    }
}
