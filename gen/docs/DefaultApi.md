# DefaultApi

All URIs are relative to *http://localhost:8000/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gamesGameIdApprovePost**](DefaultApi.md#gamesGameIdApprovePost) | **POST** /games/{game-id}/approve/ | 
[**gamesGameIdDisapprovePost**](DefaultApi.md#gamesGameIdDisapprovePost) | **POST** /games/{game-id}/disapprove/ | 
[**matchesMatchIdDropPost**](DefaultApi.md#matchesMatchIdDropPost) | **POST** /matches/{match-id}/drop/ | 
[**matchesMatchIdPlayGamePost**](DefaultApi.md#matchesMatchIdPlayGamePost) | **POST** /matches/{match-id}/play-game/ | 
[**teamsGet**](DefaultApi.md#teamsGet) | **GET** /teams/ | 
[**teamsIdGet**](DefaultApi.md#teamsIdGet) | **GET** /teams/{id}/ | 
[**tournamentsGet**](DefaultApi.md#tournamentsGet) | **GET** /tournaments/ | 
[**tournamentsPost**](DefaultApi.md#tournamentsPost) | **POST** /tournaments/ | 
[**usersMeGet**](DefaultApi.md#usersMeGet) | **GET** /users/me/ | 


<a name="gamesGameIdApprovePost"></a>
# **gamesGameIdApprovePost**
> GameDto gamesGameIdApprovePost(userId, gameId)



Approve game

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8000/api");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | 
    Integer gameId = 56; // Integer | 
    try {
      GameDto result = apiInstance.gamesGameIdApprovePost(userId, gameId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#gamesGameIdApprovePost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**|  |
 **gameId** | **Integer**|  |

### Return type

[**GameDto**](GameDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |
**400** | Validation Error |  -  |

<a name="gamesGameIdDisapprovePost"></a>
# **gamesGameIdDisapprovePost**
> GameDto gamesGameIdDisapprovePost(userId, gameId)



Disapprove game

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8000/api");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | 
    Integer gameId = 56; // Integer | 
    try {
      GameDto result = apiInstance.gamesGameIdDisapprovePost(userId, gameId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#gamesGameIdDisapprovePost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**|  |
 **gameId** | **Integer**|  |

### Return type

[**GameDto**](GameDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |
**400** | Validation Error |  -  |

<a name="matchesMatchIdDropPost"></a>
# **matchesMatchIdDropPost**
> MatchDto matchesMatchIdDropPost(userId, matchId)



Drop match games

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8000/api");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | 
    Integer matchId = 56; // Integer | 
    try {
      MatchDto result = apiInstance.matchesMatchIdDropPost(userId, matchId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#matchesMatchIdDropPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**|  |
 **matchId** | **Integer**|  |

### Return type

[**MatchDto**](MatchDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Ok |  -  |
**400** | Validation Error |  -  |

<a name="matchesMatchIdPlayGamePost"></a>
# **matchesMatchIdPlayGamePost**
> MatchDto matchesMatchIdPlayGamePost(userId, matchId, winnerId)



Add game to match

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8000/api");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | 
    Integer matchId = 56; // Integer | 
    Integer winnerId = 56; // Integer | 
    try {
      MatchDto result = apiInstance.matchesMatchIdPlayGamePost(userId, matchId, winnerId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#matchesMatchIdPlayGamePost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**|  |
 **matchId** | **Integer**|  |
 **winnerId** | **Integer**|  |

### Return type

[**MatchDto**](MatchDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |
**400** | Validation Error |  -  |

<a name="teamsGet"></a>
# **teamsGet**
> List&lt;TeamDto&gt; teamsGet(userId)



Get teams list

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8000/api");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | 
    try {
      List<TeamDto> result = apiInstance.teamsGet(userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#teamsGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**|  |

### Return type

[**List&lt;TeamDto&gt;**](TeamDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | user found |  -  |
**400** | Validation Error |  -  |

<a name="teamsIdGet"></a>
# **teamsIdGet**
> List&lt;TeamDto&gt; teamsIdGet(userId, id)



Get team by id

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8000/api");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | 
    Integer id = 56; // Integer | 
    try {
      List<TeamDto> result = apiInstance.teamsIdGet(userId, id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#teamsIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**|  |
 **id** | **Integer**|  |

### Return type

[**List&lt;TeamDto&gt;**](TeamDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | user found |  -  |

<a name="tournamentsGet"></a>
# **tournamentsGet**
> List&lt;ListTournamentDto&gt; tournamentsGet(userId)



get all Tournaments

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8000/api");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | 
    try {
      List<ListTournamentDto> result = apiInstance.tournamentsGet(userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#tournamentsGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**|  |

### Return type

[**List&lt;ListTournamentDto&gt;**](ListTournamentDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | List of tournaments |  -  |

<a name="tournamentsPost"></a>
# **tournamentsPost**
> RetrieveTournamentDto tournamentsPost(userId, body)



Create new tournament

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8000/api");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | 
    CreateTournamentDto body = new CreateTournamentDto(); // CreateTournamentDto | 
    try {
      RetrieveTournamentDto result = apiInstance.tournamentsPost(userId, body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#tournamentsPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**|  |
 **body** | [**CreateTournamentDto**](CreateTournamentDto.md)|  | [optional]

### Return type

[**RetrieveTournamentDto**](RetrieveTournamentDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |
**400** | Validation Error |  -  |

<a name="usersMeGet"></a>
# **usersMeGet**
> UserDto usersMeGet(userId)



Get self user profile info

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8000/api");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | 
    try {
      UserDto result = apiInstance.usersMeGet(userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#usersMeGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**|  |

### Return type

[**UserDto**](UserDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Ok |  -  |

