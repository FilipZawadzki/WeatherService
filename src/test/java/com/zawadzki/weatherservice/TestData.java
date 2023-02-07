package com.zawadzki.weatherservice;

import com.zawadzki.weatherservice.model.City;
import com.zawadzki.weatherservice.model.Coordinate;
import com.zawadzki.weatherservice.model.Country;

public class TestData {

    private static final String testDateInResponse = "2023-02-06";

    private static final City fortaleza = new City(new Country("Brazil"), "Fortaleza", new Coordinate("-3.731" , "-38.526"));

    private static final String JsonResonse = "{\"city_name\":\"Fortaleza\",\"country_code\":\"BR\"," +
            "\"data\":[{\"app_max_temp\":32.3,\"app_min_temp\":26.4,\"clouds\":31," +
            "\"clouds_hi\":50,\"clouds_low\":28,\"clouds_mid\":0,\"datetime\":\"2023-02-04\"," +
            "\"dewpt\":22.6,\"high_temp\":30.3,\"low_temp\":25.3,\"max_dhi\":null,\"max_temp\":30.3," +
            "\"min_temp\":25.5,\"moon_phase\":0.996607,\"moon_phase_lunation\":0.48,\"moonrise_ts\":1675541580" +
            ",\"moonset_ts\":1675499248,\"ozone\":262.2,\"pop\":60,\"precip\":4.875,\"pres\":1010.9,\"rh\":76,\"slp\":1012.9," +
            "\"snow\":0,\"snow_depth\":0,\"sunrise_ts\":1675499832,\"sunset_ts\":1675543830,\"temp\":27.4,\"ts\":1675494060," +
            "\"uv\":11.4,\"valid_date\":\"2023-02-04\",\"vis\":20.662,\"weather\":{\"description\":\"Thunderstorm with rain\"," +
            "\"code\":201,\"icon\":\"t02d\"},\"wind_cdir\":\"E\",\"wind_cdir_full\":\"east\",\"wind_dir\":92,\"wind_gust_spd\":7.2," +
            "\"wind_spd\":5.2},{\"app_max_temp\":31.5,\"app_min_temp\":26.5,\"clouds\":39,\"clouds_hi\":41,\"clouds_low\":33,\"clouds_mid\":0," +
            "\"datetime\":\"2023-02-05\",\"dewpt\":22.4,\"high_temp\":28.9,\"low_temp\":25,\"max_dhi\":null,\"max_temp\":28.9,\"min_temp\":25.3," +
            "\"moon_phase\":0.994818,\"moon_phase_lunation\":0.51,\"moonrise_ts\":1675630722,\"moonset_ts\":1675588412,\"ozone\":262,\"pop\":60," +
            "\"precip\":4.1875,\"pres\":1010.3,\"rh\":76,\"slp\":1012.2,\"snow\":0,\"snow_depth\":0,\"sunrise_ts\":1675586241,\"sunset_ts\":1675630230," +
            "\"temp\":27.1,\"ts\":1675566060,\"uv\":10.2,\"valid_date\":\"2023-02-05\",\"vis\":22.283,\"weather\":{\"description\":\"Light rain\"," +
            "\"code\":500,\"icon\":\"r01d\"},\"wind_cdir\":\"ENE\",\"wind_cdir_full\":\"east-northeast\",\"wind_dir\":77,\"wind_gust_spd\":5.5,\"wind_spd\":4.2}" +
            ",{\"app_max_temp\":31.8,\"app_min_temp\":26,\"clouds\":22,\"clouds_hi\":85,\"clouds_low\":6,\"clouds_mid\":4,\"datetime\":\"2023-02-06\"," +
            "\"dewpt\":22.4,\"high_temp\":29,\"low_temp\":24.7,\"max_dhi\":null,\"max_temp\":29,\"min_temp\":25,\"moon_phase\":0.974033," +
            "\"moon_phase_lunation\":0.55,\"moonrise_ts\":1675719715,\"moonset_ts\":1675677451,\"ozone\":264.1,\"pop\":55,\"precip\":3.875,\"pres\":1009.2,\"rh\":77," +
            "\"slp\":1011.2,\"snow\":0,\"snow_depth\":0,\"sunrise_ts\":1675672649,\"sunset_ts\":1675716629,\"temp\":26.9,\"ts\":1675652460,\"uv\":9.6," +
            "\"valid_date\":\"2023-02-06\",\"vis\":23.347,\"weather\":{\"description\":\"Light rain\",\"code\":500,\"icon\":\"r01d\"},\"wind_cdir\":\"E\"," +
            "\"wind_cdir_full\":\"east\",\"wind_dir\":81,\"wind_gust_spd\":4.5,\"wind_spd\":3.5},{\"app_max_temp\":31,\"app_min_temp\":25.6,\"clouds\":22," +
            "\"clouds_hi\":82,\"clouds_low\":12,\"clouds_mid\":1,\"datetime\":\"2023-02-07\",\"dewpt\":22.2,\"high_temp\":28.6,\"low_temp\":23.6," +
            "\"max_dhi\":null,\"max_temp\":28.6,\"min_temp\":24.7,\"moon_phase\":0.934753,\"moon_phase_lunation\":0.58,\"moonrise_ts\":1675808587," +
            "\"moonset_ts\":1675766399,\"ozone\":263.5,\"pop\":65,\"precip\":5.6875,\"pres\":1008.7,\"rh\":77,\"slp\":1010.6,\"snow\":0,\"snow_depth\":0," +
            "\"sunrise_ts\":1675759057,\"sunset_ts\":1675803028,\"temp\":26.6,\"ts\":1675738860,\"uv\":10.5,\"valid_date\":\"2023-02-07\",\"vis\":21.461," +
            "\"weather\":{\"description\":\"Moderate rain\",\"code\":501,\"icon\":\"r02d\"},\"wind_cdir\":\"E\",\"wind_cdir_full\":\"east\"," +
            "\"wind_dir\":84,\"wind_gust_spd\":4.3,\"wind_spd\":3.3},{\"app_max_temp\":30.6,\"app_min_temp\":24.5,\"clouds\":29,\"clouds_hi\":77,\"clouds_low\":7," +
            "\"clouds_mid\":19,\"datetime\":\"2023-02-08\",\"dewpt\":21.9,\"high_temp\":28.4,\"low_temp\":25.2,\"max_dhi\":null,\"max_temp\":28.4,\"min_temp\":23.6," +
            "\"moon_phase\":0.877935,\"moon_phase_lunation\":0.62,\"moonrise_ts\":1675897387,\"moonset_ts\":1675855305,\"ozone\":265.4,\"pop\":60,\"precip\":4.5," +
            "\"pres\":1008.8,\"rh\":78,\"slp\":1010.8,\"snow\":0,\"snow_depth\":0,\"sunrise_ts\":1675845464,\"sunset_ts\":1675889426,\"temp\":26.1,\"ts\":1675825260," +
            "\"uv\":10.1,\"valid_date\":\"2023-02-08\",\"vis\":22.72,\"weather\":{\"description\":\"Light rain\",\"code\":500,\"icon\":\"r01d\"},\"wind_cdir\":\"ESE\"," +
            "\"wind_cdir_full\":\"east-southeast\",\"wind_dir\":109,\"wind_gust_spd\":4.1,\"wind_spd\":3.2},{\"app_max_temp\":30,\"app_min_temp\":26.3,\"clouds\":27," +
            "\"clouds_hi\":94,\"clouds_low\":12,\"clouds_mid\":12,\"datetime\":\"2023-02-09\",\"dewpt\":22.6,\"high_temp\":27.3,\"low_temp\":25.2,\"max_dhi\":null," +
            "\"max_temp\":27.3,\"min_temp\":25.2,\"moon_phase\":0.804892,\"moon_phase_lunation\":0.65,\"moonrise_ts\":1675986171,\"moonset_ts\":1675944231," +
            "\"ozone\":262.2,\"pop\":75,\"precip\":8.1875,\"pres\":1008.7,\"rh\":81,\"slp\":1010.6,\"snow\":0,\"snow_depth\":0,\"sunrise_ts\":1675931870," +
            "\"sunset_ts\":1675975823,\"temp\":26.1,\"ts\":1675911660,\"uv\":11.3,\"valid_date\":\"2023-02-09\",\"vis\":21.381,\"weather\":{\"description\":\"Moderate rain\"," +
            "\"code\":501,\"icon\":\"r02d\"},\"wind_cdir\":\"E\",\"wind_cdir_full\":\"east\",\"wind_dir\":94,\"wind_gust_spd\":4.7,\"wind_spd\":3.3},{\"app_max_temp\":31," +
            "\"app_min_temp\":26.1,\"clouds\":11,\"clouds_hi\":19,\"clouds_low\":10,\"clouds_mid\":0,\"datetime\":\"2023-02-10\",\"dewpt\":22.9,\"high_temp\":28.4," +
            "\"low_temp\":24.7,\"max_dhi\":null,\"max_temp\":28.4,\"min_temp\":25.1,\"moon_phase\":0.717309,\"moon_phase_lunation\":0.68,\"moonrise_ts\":1676072571" +
            ",\"moonset_ts\":1676033244,\"ozone\":258,\"pop\":80,\"precip\":11.5625,\"pres\":1008.8,\"rh\":81,\"slp\":1010.6,\"snow\":0,\"snow_depth\":0," +
            "\"sunrise_ts\":1676018275,\"sunset_ts\":1676062219,\"temp\":26.5,\"ts\":1675998060,\"uv\":11.3,\"valid_date\":\"2023-02-10\",\"vis\":20.531," +
            "\"weather\":{\"description\":\"Moderate rain\",\"code\":501,\"icon\":\"r02d\"},\"wind_cdir\":\"E\",\"wind_cdir_full\":\"east\",\"wind_dir\":94," +
            "\"wind_gust_spd\":6.5,\"wind_spd\":4.5}],\"lat\":-3.731,\"lon\":-38.526,\"state_code\":\"06\",\"timezone\":\"America/Fortaleza\"}";

    public static City getFortaleza() {
        return fortaleza;
    }

    public static String getJsonResonse() {
        return JsonResonse;
    }

    public static String getTestDateInResponse() {
        return testDateInResponse;
    }
}
