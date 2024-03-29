package com.basterikus.cs_money_service.utils.parser;

import com.basterikus.cs_money_service.config.ParseConfig;
import com.basterikus.cs_money_service.dto.ItemDto;
import com.basterikus.cs_money_service.exception.CsMoneyParsingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import com.basterikus.cs_money_service.utils.RandomUserAgent;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@EnableConfigurationProperties(ParseConfig.class)
@RequiredArgsConstructor
public class Parser {

    private final ParseConfig parseConfig;

    public List<ItemDto> parse(int type, int minPrice, int maxPrice) {
        List<ItemDto> skins = new ArrayList<>();
        int offset = 0;
        int step = 60;
        int count = 0;
        String userAgent = RandomUserAgent.getRandomUserAgent();
        try {
            while (true) {
                String url = parseConfig.getUrl() + "&maxPrice=" + maxPrice + "&minPrice=" + minPrice + "&offset="
                        + offset + "&type=" + type + "&withStack=true";
                String json = Jsoup.connect(url)
                        .userAgent(userAgent)
                        .ignoreContentType(true)
                        .execute()
                        .body();
                offset += step;
                count++;
                JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);
                if (jsonObject.get("items") == null) {
                    log.info("Parsing end");
                    break;
                }
                JSONArray items = (JSONArray) jsonObject.get("items");

                for (Object i : items) {
                    JSONObject item = (JSONObject) i;
                    skins.add(convertJsonToItemDto(item));
                }
                log.info("Parsing page " + count);
                if (items.size() < 60) {
                    log.info("Parsing end");
                    break;
                }
            }
        } catch (Exception e) {
            log.error("json parsing error", e);
            throw new CsMoneyParsingException(e);
        }
        return skins;
    }

    private ItemDto convertJsonToItemDto(JSONObject item) {
        String itemName = item.get("fullName").toString();
        String itemId = item.get("id").toString();
        String item3d = item.get("3d").toString();
        String itemType = item.get("type").toString();
        String itemFloat = item.get("float").toString();
        String itemQuality;
        String itemImg = item.get("img").toString();
        String itemStatTrak;
        String itemRarity = item.get("rarity").toString();
        String itemScreenshot = item.get("screenshot").toString();
        String itemStickers;
        String itemPrice = item.get("price").toString();
        String itemOverprice;
        if (item.get("quality") != null) {
            itemQuality = item.get("quality").toString();
        } else itemQuality = "unknown";
        if (item.get("overprice") != null) {
            itemOverprice = item.get("overprice").toString();
        } else itemOverprice = "0";
        if (item.get("stickers") != null) {
            itemStickers = item.get("stickers").toString();
        } else itemStickers = "null";
        if (item.get("isStatTrak") != null) {
            itemStatTrak = item.get("isStatTrak").toString();
        } else itemStatTrak = "false";

        return new ItemDto(
                itemName,
                Long.parseLong(itemId),
                item3d,
                itemType,
                Double.parseDouble(itemFloat),
                itemQuality,
                itemImg,
                itemStatTrak,
                itemRarity,
                itemScreenshot,
                itemStickers,
                Double.parseDouble(itemPrice),
                Double.parseDouble(itemOverprice)
        );
    }
}
