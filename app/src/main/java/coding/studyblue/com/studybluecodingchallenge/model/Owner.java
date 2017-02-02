package coding.studyblue.com.studybluecodingchallenge.model;


public class Owner {


    private String login;

    private long id;

    private String avatar_url;

    private String gravatar_id;

    private String url;

    private String html_url;

    private String followers_url;

    private String following_url;

    private String gists_url;

    private String starred_url;

    private String subscriptions_url;

    private String organizations_url;

    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private boolean site_admin;

    public Owner() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Owner withLogin(String login) {
        this.login = login;
        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Owner withId(long id) {
        this.id = id;
        return this;
    }

    public String getAvatarUrl() {
        return avatar_url;
    }

    public void setAvatarUrl(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public Owner withAvatarUrl(String avatar_url) {
        this.avatar_url = avatar_url;
        return this;
    }

    public String getGravatarId() {
        return gravatar_id;
    }

    public void setGravatarId(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }

    public Owner withGravatarId(String gravatar_id) {
        this.gravatar_id = gravatar_id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Owner withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public Owner withHtmlUrl(String htmlUrl) {
        this.html_url = htmlUrl;
        return this;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }

    public Owner withFollowersUrl(String followersUrl) {
        this.followers_url = followersUrl;
        return this;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public void setFollowing_url(String following_url) {
        this.following_url = following_url;
    }

    public Owner withFollowingUrl(String followingUrl) {
        this.following_url = followingUrl;
        return this;
    }

    public String getGists_url() {
        return gists_url;
    }

    public void setGists_url(String gists_url) {
        this.gists_url = gists_url;
    }

    public Owner withGistsUrl(String gistsUrl) {
        this.gists_url = gistsUrl;
        return this;
    }

    public String getStarred_url() {
        return starred_url;
    }

    public void setStarred_url(String starred_url) {
        this.starred_url = starred_url;
    }

    public Owner withStarredUrl(String starredUrl) {
        this.starred_url = starredUrl;
        return this;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public void setSubscriptions_url(String subscriptions_url) {
        this.subscriptions_url = subscriptions_url;
    }

    public Owner withSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptions_url = subscriptionsUrl;
        return this;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public void setOrganizations_url(String organizations_url) {
        this.organizations_url = organizations_url;
    }

    public Owner withOrganizationsUrl(String organizationsUrl) {
        this.organizations_url = organizationsUrl;
        return this;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    public Owner withReposUrl(String reposUrl) {
        this.repos_url = reposUrl;
        return this;
    }

    public String getEventsUrl() {
        return events_url;
    }

    public void setEventsUrl(String events_url) {
        this.events_url = events_url;
    }

    public Owner withEventsUrl(String events_url) {
        this.events_url = events_url;
        return this;
    }

    public String getReceived_events_url() {
        return received_events_url;
    }

    public void setReceived_events_url(String received_events_url) {
        this.received_events_url = received_events_url;
    }

    public Owner withReceivedEventsUrl(String receivedEventsUrl) {
        this.received_events_url = receivedEventsUrl;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Owner withType(String type) {
        this.type = type;
        return this;
    }

    public boolean isSiteAdmin() {
        return site_admin;
    }

    public void setSiteAdmin(boolean site_admin) {
        this.site_admin = site_admin;
    }

    public Owner withSiteAdmin(boolean siteAdmin) {
        this.site_admin = siteAdmin;
        return this;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", avatar_url='" + avatar_url + '\'' +
                ", gravatar_id='" + gravatar_id + '\'' +
                ", url='" + url + '\'' +
                ", html_url='" + html_url + '\'' +
                ", followers_url='" + followers_url + '\'' +
                ", following_url='" + following_url + '\'' +
                ", gists_url='" + gists_url + '\'' +
                ", starred_url='" + starred_url + '\'' +
                ", subscriptions_url='" + subscriptions_url + '\'' +
                ", organizations_url='" + organizations_url + '\'' +
                ", repos_url='" + repos_url + '\'' +
                ", events_url='" + events_url + '\'' +
                ", received_events_url='" + received_events_url + '\'' +
                ", type='" + type + '\'' +
                ", site_admin=" + site_admin +
                '}';
    }
}
