(ns happygapi.youtube.liveStreams
  "YouTube Data API v3: liveStreams.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/api/reference/rest/v3/liveStreams"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/youtube/api/reference/rest/v3/liveStreams/delete
  
  Required parameters: id
  
  Optional parameters: onBehalfOfContentOwnerChannel, onBehalfOfContentOwner
  
  Deletes an existing stream for the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/liveStreams"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/youtube/api/reference/rest/v3/liveStreams/insert
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwnerChannel, onBehalfOfContentOwner
  
  Body: 
  
  {:cdn {:resolution string,
         :ingestionInfo IngestionInfo,
         :ingestionType string,
         :frameRate string,
         :format string},
   :snippet {:title string,
             :publishedAt string,
             :isDefaultStream boolean,
             :channelId string,
             :description string},
   :status {:streamStatus string, :healthStatus LiveStreamHealthStatus},
   :kind string,
   :contentDetails {:closedCaptionsIngestionUrl string,
                    :isReusable boolean},
   :id string,
   :etag string}
  
  Inserts a new stream for the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/liveStreams"
     #{:part}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/youtube/api/reference/rest/v3/liveStreams/list
  
  Required parameters: part
  
  Optional parameters: maxResults, mine, onBehalfOfContentOwner, onBehalfOfContentOwnerChannel, id, pageToken
  
  Retrieve the list of streams associated with the given channel. --"
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/liveStreams"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/youtube/api/reference/rest/v3/liveStreams/update
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwnerChannel, onBehalfOfContentOwner
  
  Body: 
  
  {:cdn {:resolution string,
         :ingestionInfo IngestionInfo,
         :ingestionType string,
         :frameRate string,
         :format string},
   :snippet {:title string,
             :publishedAt string,
             :isDefaultStream boolean,
             :channelId string,
             :description string},
   :status {:streamStatus string, :healthStatus LiveStreamHealthStatus},
   :kind string,
   :contentDetails {:closedCaptionsIngestionUrl string,
                    :isReusable boolean},
   :id string,
   :etag string}
  
  Updates an existing stream for the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/liveStreams"
     #{:part}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
