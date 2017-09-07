## 按月分组：汇总sum
      @Query(value = "SELECT channelId as channelId,model as model,date_format(re.date,'%Y-%m') as date,sum(re.dayLivingCount) as dayLivingCount," +
            "sum(re.yellowDayLiving) as yellowDayLiving,sum(re.smsDayLiving) as smsDayLiving,sum(re.userCount) as userCount " +
            "from ReportDeviceType re GROUP by  date_format(?1,'%Y-%m')")
    Page<Map<String,Object>> getByMonth(Date date, Pageable pageRequest);
## 按月分组：条件判断
    @Query(value = "SELECT date_format(re.date,'%Y-%m') as date,sum(re.clickCount) as clickCount,sum(re.clickPeopleCount) as clickPeopleCount " +
            "from ReportMenuButtonClick re WHERE 1=1 " +
            "and (re.version =?3 or ?3 = null or ?3 = '')"+
            "and (re.model =?4 or ?4 = null or ?4 = '')"+
            "and (re.channelId =?5 or ?5 = null or ?5 = '')"+
            "and date_format(re.date,'%Y-%m') BETWEEN  date_format(?1,'%Y-%m') " +
            "and  date_format(?2,'%Y-%m') GROUP by  date_format(re.date,'%Y-%m') ")
    Page<Map<String,Object>> getByMonth(String sd, String ed, String version, String model,String channel,Pageable pageRequest);