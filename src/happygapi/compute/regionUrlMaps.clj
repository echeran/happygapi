(ns happygapi.compute.regionUrlMaps
  "Compute Engine API: regionUrlMaps.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/regionUrlMaps"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionUrlMaps/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves the list of UrlMap resources available to the specified project in the specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/urlMaps"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionUrlMaps/get
  
  Required parameters: project, region, urlMap
  
  Optional parameters: none
  
  Returns the specified UrlMap resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:urlMap :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/urlMaps/{urlMap}"
     #{:urlMap :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionUrlMaps/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :pathMatchers [{:name string,
                   :description string,
                   :defaultService string,
                   :defaultRouteAction HttpRouteAction,
                   :defaultUrlRedirect HttpRedirectAction,
                   :pathRules [PathRule],
                   :routeRules [HttpRouteRule],
                   :headerAction HttpHeaderAction}],
   :creationTimestamp string,
   :tests [{:description string,
            :host string,
            :path string,
            :headers [UrlMapTestHeader],
            :service string,
            :expectedOutputUrl string,
            :expectedRedirectResponseCode integer}],
   :name string,
   :defaultUrlRedirect {:hostRedirect string,
                        :pathRedirect string,
                        :prefixRedirect string,
                        :redirectResponseCode string,
                        :httpsRedirect boolean,
                        :stripQuery boolean},
   :selfLink string,
   :headerAction {:requestHeadersToRemove [string],
                  :requestHeadersToAdd [HttpHeaderOption],
                  :responseHeadersToRemove [string],
                  :responseHeadersToAdd [HttpHeaderOption]},
   :region string,
   :defaultRouteAction {:weightedBackendServices [WeightedBackendService],
                        :urlRewrite UrlRewrite,
                        :timeout Duration,
                        :retryPolicy HttpRetryPolicy,
                        :requestMirrorPolicy RequestMirrorPolicy,
                        :corsPolicy CorsPolicy,
                        :faultInjectionPolicy HttpFaultInjection,
                        :maxStreamDuration Duration},
   :defaultService string,
   :id string,
   :kind string,
   :hostRules [{:description string,
                :hosts [string],
                :pathMatcher string}],
   :fingerprint string}
  
  Creates a UrlMap resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/urlMaps"
     #{:region :project}
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

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionUrlMaps/delete
  
  Required parameters: project, region, urlMap
  
  Optional parameters: requestId
  
  Deletes the specified UrlMap resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:urlMap :region :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/urlMaps/{urlMap}"
     #{:urlMap :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionUrlMaps/update
  
  Required parameters: project, region, urlMap
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :pathMatchers [{:name string,
                   :description string,
                   :defaultService string,
                   :defaultRouteAction HttpRouteAction,
                   :defaultUrlRedirect HttpRedirectAction,
                   :pathRules [PathRule],
                   :routeRules [HttpRouteRule],
                   :headerAction HttpHeaderAction}],
   :creationTimestamp string,
   :tests [{:description string,
            :host string,
            :path string,
            :headers [UrlMapTestHeader],
            :service string,
            :expectedOutputUrl string,
            :expectedRedirectResponseCode integer}],
   :name string,
   :defaultUrlRedirect {:hostRedirect string,
                        :pathRedirect string,
                        :prefixRedirect string,
                        :redirectResponseCode string,
                        :httpsRedirect boolean,
                        :stripQuery boolean},
   :selfLink string,
   :headerAction {:requestHeadersToRemove [string],
                  :requestHeadersToAdd [HttpHeaderOption],
                  :responseHeadersToRemove [string],
                  :responseHeadersToAdd [HttpHeaderOption]},
   :region string,
   :defaultRouteAction {:weightedBackendServices [WeightedBackendService],
                        :urlRewrite UrlRewrite,
                        :timeout Duration,
                        :retryPolicy HttpRetryPolicy,
                        :requestMirrorPolicy RequestMirrorPolicy,
                        :corsPolicy CorsPolicy,
                        :faultInjectionPolicy HttpFaultInjection,
                        :maxStreamDuration Duration},
   :defaultService string,
   :id string,
   :kind string,
   :hostRules [{:description string,
                :hosts [string],
                :pathMatcher string}],
   :fingerprint string}
  
  Updates the specified UrlMap resource with the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:urlMap :region :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/urlMaps/{urlMap}"
     #{:urlMap :region :project}
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

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionUrlMaps/patch
  
  Required parameters: project, region, urlMap
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :pathMatchers [{:name string,
                   :description string,
                   :defaultService string,
                   :defaultRouteAction HttpRouteAction,
                   :defaultUrlRedirect HttpRedirectAction,
                   :pathRules [PathRule],
                   :routeRules [HttpRouteRule],
                   :headerAction HttpHeaderAction}],
   :creationTimestamp string,
   :tests [{:description string,
            :host string,
            :path string,
            :headers [UrlMapTestHeader],
            :service string,
            :expectedOutputUrl string,
            :expectedRedirectResponseCode integer}],
   :name string,
   :defaultUrlRedirect {:hostRedirect string,
                        :pathRedirect string,
                        :prefixRedirect string,
                        :redirectResponseCode string,
                        :httpsRedirect boolean,
                        :stripQuery boolean},
   :selfLink string,
   :headerAction {:requestHeadersToRemove [string],
                  :requestHeadersToAdd [HttpHeaderOption],
                  :responseHeadersToRemove [string],
                  :responseHeadersToAdd [HttpHeaderOption]},
   :region string,
   :defaultRouteAction {:weightedBackendServices [WeightedBackendService],
                        :urlRewrite UrlRewrite,
                        :timeout Duration,
                        :retryPolicy HttpRetryPolicy,
                        :requestMirrorPolicy RequestMirrorPolicy,
                        :corsPolicy CorsPolicy,
                        :faultInjectionPolicy HttpFaultInjection,
                        :maxStreamDuration Duration},
   :defaultService string,
   :id string,
   :kind string,
   :hostRules [{:description string,
                :hosts [string],
                :pathMatcher string}],
   :fingerprint string}
  
  Patches the specified UrlMap resource with the data included in the request. This method supports PATCH semantics and uses JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:urlMap :region :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/urlMaps/{urlMap}"
     #{:urlMap :region :project}
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

(defn validate$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionUrlMaps/validate
  
  Required parameters: project, region, urlMap
  
  Optional parameters: none
  
  Body: 
  
  {:resource {:description string,
              :pathMatchers [PathMatcher],
              :creationTimestamp string,
              :tests [UrlMapTest],
              :name string,
              :defaultUrlRedirect HttpRedirectAction,
              :selfLink string,
              :headerAction HttpHeaderAction,
              :region string,
              :defaultRouteAction HttpRouteAction,
              :defaultService string,
              :id string,
              :kind string,
              :hostRules [HostRule],
              :fingerprint string}}
  
  Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be run. Calling this method does NOT create the UrlMap."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:urlMap :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/urlMaps/{urlMap}/validate"
     #{:urlMap :region :project}
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
