   ### spring data jpa多条件查询
   #### 需要repostiory接口继承JpaSpecificationExecutor
    `public Page<ClientException> searchPageException(final ClientException clientException,Integer curPage, Integer pageSize){
        if(clientException == null){
            Pageable pageable = new PageRequest(curPage-1, pageSize, new Sort(Direction.DESC, "createdDate"));
            Page<ClientException> pageException = clientExceptionRepository.findAll(pageable);
            return pageException;
        }else{
            Page<ClientException> pageException = clientExceptionRepository.findAll(new Specification<ClientException>() {
                @Override
                public Predicate toPredicate(Root<ClientException> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                    List<Predicate> list = new ArrayList<Predicate>();
                     if(StringUtils.isNotBlank(clientException.getAppName()) && !"-1".equals(clientException.getAppName())){
                         list.add(cb.equal(root.get("appName").as(String.class), clientException.getAppName()));
                     }
                     if(StringUtils.isNotBlank(clientException.getAppChannel()) && !"-1".equals(clientException.getAppChannel())){
                         list.add(cb.equal(root.get("appChannel").as(String.class), clientException.getAppChannel()));
                     }
                     if(StringUtils.isNotBlank(clientException.getVersionCode()) && !"-1".equals(clientException.getVersionCode())){
                         list.add(cb.equal(root.get("versionCode").as(String.class), clientException.getVersionCode()));
                     }
                     if(StringUtils.isNotBlank(clientException.getOsName()) && !"-1".equals(clientException.getOsName())){
                         list.add(cb.equal(root.get("osName").as(String.class), clientException.getOsName()));
                     }
                    Predicate[] p = new Predicate[list.size()];
                    return cb.and(list.toArray(p));
                }
            }, new PageRequest(curPage-1, pageSize));
            return pageException;
        }
    }  
    `
    ### jdk1.7以上用lambda表达式
    ` public Page<MsgCardType> selectModelByCondition(String cardName, String channelId, CurrentUser currentUser, PageRequest pageRequest) {
        Page<MsgCardType> page = msgCardTypeRepository.findAll((root, query, cb) -> {
            List<Predicate> list = new ArrayList<>();
            Set<Channel> channels =new HashSet<>();
            if(StringUtils.isNotBlank(cardName)){
                list.add(cb.like(root.get("name").as(String.class),cardName));
            }
            if(StringUtils.isNotBlank(channelId)){
                Channel channel = channelRepository.findOne(channelId);
                channels.add(channel);
                Expression<String> exp = root.get("channel");
                Predicate predicate = exp.in(channels);
                list.add(predicate);
            }
            if(StringUtils.isBlank(channelId)){
                channels = currentUser.getChannelsWithCommon();
                Expression<String> exp = root.get("channel");
                Predicate predicate = exp.in(channels);
                list.add(predicate);
            }
            return cb.and(list.toArray(new Predicate[list.size()]));
        },pageRequest);
        return page;
    }`
    
