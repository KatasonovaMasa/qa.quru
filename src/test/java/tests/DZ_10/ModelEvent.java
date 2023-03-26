package tests.DZ_10;

import java.util.Map;

public class ModelEvent {
    private String apiVersion,
            channelType,
            userId,
            title;

    private int counterId,
            timestamp;

    private Map<String, Object> customparams;

    public String getApiVersion() {
        return apiVersion;
    }
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getChannelType() {
        return channelType;
    }
    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTtitle(String title) {
        this.title = title;
    }

    public Integer getCounterId(){
        return counterId;
    }

   public void setCounterId(int counterId) {
        this.counterId = counterId;
    }

    public Integer getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, Object> getCustomparams() {
        return customparams;
    }

    public void setCustomparams(Map<String, Object> customparams) {
        this.customparams = customparams;
    }
}
