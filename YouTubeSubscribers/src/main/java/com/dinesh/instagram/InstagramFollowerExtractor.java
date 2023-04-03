package com.dinesh.instagram;
import com.github.instagram4j.instagram4j.IGClient;
import com.github.instagram4j.instagram4j.exceptions.IGLoginException;
import com.github.instagram4j.instagram4j.models.user.Profile;
import com.github.instagram4j.instagram4j.requests.accounts.AccountsActionRequest;
import com.github.instagram4j.instagram4j.requests.accounts.AccountsGetRequest;
import com.github.instagram4j.instagram4j.requests.users.UsersInfoRequest;
import com.github.instagram4j.instagram4j.responses.accounts.AccountsActionResponse;
import com.github.instagram4j.instagram4j.responses.accounts.AccountsGetResponse;
import com.github.instagram4j.instagram4j.responses.users.UsersInfoResponse;

public class InstagramFollowerExtractor {
    public static void main(String[] args) {
        // Replace these values with your own client ID, client secret, and access token
        String clientId = "YOUR_CLIENT_ID";
        String clientSecret = "YOUR_CLIENT_SECRET";
        String accessToken = "YOUR_ACCESS_TOKEN";
        
        // Create a new Instagram client using the client ID, client secret, and access token
        IGClient client = IGClient.builder()
                .username("YOUR_USERNAME")
                .password("YOUR_PASSWORD")
                .client(clientId, clientSecret)
                .accessToken(accessToken)
                .login();
        
        // Get information about the authenticated user
        UsersInfoResponse userInfo = client.sendRequest(new UsersInfoRequest(client.getUserId())).join();
        Profile user = userInfo.getUser();
        
        // Get a list of the user's followers
        AccountsGetResponse<Account> followers = client.sendRequest(new AccountsGetRequest(user.getPk())).join();
        List<Account> followerList = followers.getUsers();
        
        // Print out the number of followers
        System.out.println("Number of followers: " + followerList.size());
        
        // Do something with the list of followers...
    }
}
