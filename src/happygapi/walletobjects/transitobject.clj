(ns happygapi.walletobjects.transitobject
  "Google Wallet API: transitobject.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesapi/reference/rest/v1/transitobject"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/transitobject/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:ticketStatus string,
   :purchaseDetails {:ticketCost TicketCost,
                     :purchaseReceiptNumber string,
                     :accountId string,
                     :purchaseDateTime string,
                     :confirmationCode string},
   :ticketLegs [{:originName LocalizedString,
                 :destinationName LocalizedString,
                 :zone string,
                 :originStationCode string,
                 :transitOperatorName LocalizedString,
                 :ticketSeats [TicketSeat],
                 :transitTerminusName LocalizedString,
                 :destinationStationCode string,
                 :arrivalDateTime string,
                 :departureDateTime string,
                 :ticketSeat TicketSeat,
                 :fareName LocalizedString,
                 :platform string,
                 :carriage string}],
   :hasUsers boolean,
   :smartTapRedemptionValue string,
   :rotatingBarcode {:totpDetails RotatingBarcodeTotpDetails,
                     :initialRotatingBarcodeValues RotatingBarcodeValues,
                     :showCodeText LocalizedString,
                     :type string,
                     :valuePattern string,
                     :alternateText string,
                     :renderEncoding string},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :tripType string,
   :barcode {:alternateText string,
             :showCodeText LocalizedString,
             :type string,
             :renderEncoding string,
             :value string,
             :kind string},
   :passengerType string,
   :hasLinkedDevice boolean,
   :groupingInfo {:groupingId string, :sortIndex integer},
   :state string,
   :customConcessionCategory {:defaultValue TranslatedString,
                              :translatedValues [TranslatedString],
                              :kind string},
   :classReference {:wordMark Image,
                    :transitType string,
                    :customFareNameLabel LocalizedString,
                    :customDiscountMessageLabel LocalizedString,
                    :customPlatformLabel LocalizedString,
                    :reviewStatus string,
                    :customRouteRestrictionsDetailsLabel LocalizedString,
                    :customCarriageLabel LocalizedString,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :customZoneLabel LocalizedString,
                    :customFareClassLabel LocalizedString,
                    :customPurchaseReceiptNumberLabel LocalizedString,
                    :logo Image,
                    :activationOptions ActivationOptions,
                    :enableSingleLegItinerary boolean,
                    :wideLogo Image,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :transitOperatorName LocalizedString,
                    :homepageUri Uri,
                    :customConcessionCategoryLabel LocalizedString,
                    :customSeatLabel LocalizedString,
                    :customTransitTerminusNameLabel LocalizedString,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :customRouteRestrictionsLabel LocalizedString,
                    :locations [LatLongPoint],
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :customTimeRestrictionsLabel LocalizedString,
                    :customOtherRestrictionsLabel LocalizedString,
                    :messages [Message],
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :review Review,
                    :id string,
                    :customPurchaseFaceValueLabel LocalizedString,
                    :customConfirmationCodeLabel LocalizedString,
                    :customCoachLabel LocalizedString,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :version string,
                    :customPurchasePriceLabel LocalizedString,
                    :viewUnlockRequirement string,
                    :infoModuleData InfoModuleData,
                    :heroImage Image,
                    :watermark Image,
                    :countryCode string,
                    :customTicketNumberLabel LocalizedString,
                    :languageOverride string},
   :disableExpirationNotification boolean,
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :ticketLeg {:originName LocalizedString,
               :destinationName LocalizedString,
               :zone string,
               :originStationCode string,
               :transitOperatorName LocalizedString,
               :ticketSeats [TicketSeat],
               :transitTerminusName LocalizedString,
               :destinationStationCode string,
               :arrivalDateTime string,
               :departureDateTime string,
               :ticketSeat TicketSeat,
               :fareName LocalizedString,
               :platform string,
               :carriage string},
   :validTimeInterval {:start DateTime, :kind string, :end DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :hexBackgroundColor string,
   :messages [{:body string,
               :messageType string,
               :header string,
               :id string,
               :kind string,
               :displayInterval TimeInterval,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString}],
   :ticketNumber string,
   :id string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :webAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :concessionCategory string,
   :passengerNames string,
   :ticketRestrictions {:timeRestrictions LocalizedString,
                        :otherRestrictions LocalizedString,
                        :routeRestrictionsDetails LocalizedString,
                        :routeRestrictions LocalizedString},
   :tripId string,
   :version string,
   :deviceContext {:deviceToken string},
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :customTicketStatus {:defaultValue TranslatedString,
                        :translatedValues [TranslatedString],
                        :kind string},
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :activationStatus {:state string}}
  
  Updates the transit object referenced by the given object ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitObject/{resourceId}"
     #{:resourceId}
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

(defn update$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/transitobject/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:ticketStatus string,
   :purchaseDetails {:ticketCost TicketCost,
                     :purchaseReceiptNumber string,
                     :accountId string,
                     :purchaseDateTime string,
                     :confirmationCode string},
   :ticketLegs [{:originName LocalizedString,
                 :destinationName LocalizedString,
                 :zone string,
                 :originStationCode string,
                 :transitOperatorName LocalizedString,
                 :ticketSeats [TicketSeat],
                 :transitTerminusName LocalizedString,
                 :destinationStationCode string,
                 :arrivalDateTime string,
                 :departureDateTime string,
                 :ticketSeat TicketSeat,
                 :fareName LocalizedString,
                 :platform string,
                 :carriage string}],
   :hasUsers boolean,
   :smartTapRedemptionValue string,
   :rotatingBarcode {:totpDetails RotatingBarcodeTotpDetails,
                     :initialRotatingBarcodeValues RotatingBarcodeValues,
                     :showCodeText LocalizedString,
                     :type string,
                     :valuePattern string,
                     :alternateText string,
                     :renderEncoding string},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :tripType string,
   :barcode {:alternateText string,
             :showCodeText LocalizedString,
             :type string,
             :renderEncoding string,
             :value string,
             :kind string},
   :passengerType string,
   :hasLinkedDevice boolean,
   :groupingInfo {:groupingId string, :sortIndex integer},
   :state string,
   :customConcessionCategory {:defaultValue TranslatedString,
                              :translatedValues [TranslatedString],
                              :kind string},
   :classReference {:wordMark Image,
                    :transitType string,
                    :customFareNameLabel LocalizedString,
                    :customDiscountMessageLabel LocalizedString,
                    :customPlatformLabel LocalizedString,
                    :reviewStatus string,
                    :customRouteRestrictionsDetailsLabel LocalizedString,
                    :customCarriageLabel LocalizedString,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :customZoneLabel LocalizedString,
                    :customFareClassLabel LocalizedString,
                    :customPurchaseReceiptNumberLabel LocalizedString,
                    :logo Image,
                    :activationOptions ActivationOptions,
                    :enableSingleLegItinerary boolean,
                    :wideLogo Image,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :transitOperatorName LocalizedString,
                    :homepageUri Uri,
                    :customConcessionCategoryLabel LocalizedString,
                    :customSeatLabel LocalizedString,
                    :customTransitTerminusNameLabel LocalizedString,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :customRouteRestrictionsLabel LocalizedString,
                    :locations [LatLongPoint],
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :customTimeRestrictionsLabel LocalizedString,
                    :customOtherRestrictionsLabel LocalizedString,
                    :messages [Message],
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :review Review,
                    :id string,
                    :customPurchaseFaceValueLabel LocalizedString,
                    :customConfirmationCodeLabel LocalizedString,
                    :customCoachLabel LocalizedString,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :version string,
                    :customPurchasePriceLabel LocalizedString,
                    :viewUnlockRequirement string,
                    :infoModuleData InfoModuleData,
                    :heroImage Image,
                    :watermark Image,
                    :countryCode string,
                    :customTicketNumberLabel LocalizedString,
                    :languageOverride string},
   :disableExpirationNotification boolean,
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :ticketLeg {:originName LocalizedString,
               :destinationName LocalizedString,
               :zone string,
               :originStationCode string,
               :transitOperatorName LocalizedString,
               :ticketSeats [TicketSeat],
               :transitTerminusName LocalizedString,
               :destinationStationCode string,
               :arrivalDateTime string,
               :departureDateTime string,
               :ticketSeat TicketSeat,
               :fareName LocalizedString,
               :platform string,
               :carriage string},
   :validTimeInterval {:start DateTime, :kind string, :end DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :hexBackgroundColor string,
   :messages [{:body string,
               :messageType string,
               :header string,
               :id string,
               :kind string,
               :displayInterval TimeInterval,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString}],
   :ticketNumber string,
   :id string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :webAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :concessionCategory string,
   :passengerNames string,
   :ticketRestrictions {:timeRestrictions LocalizedString,
                        :otherRestrictions LocalizedString,
                        :routeRestrictionsDetails LocalizedString,
                        :routeRestrictions LocalizedString},
   :tripId string,
   :version string,
   :deviceContext {:deviceToken string},
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :customTicketStatus {:defaultValue TranslatedString,
                        :translatedValues [TranslatedString],
                        :kind string},
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :activationStatus {:state string}}
  
  Updates the transit object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitObject/{resourceId}"
     #{:resourceId}
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

(defn addmessage$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/transitobject/addmessage
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:message {:body string,
             :messageType string,
             :header string,
             :id string,
             :kind string,
             :displayInterval TimeInterval,
             :localizedHeader LocalizedString,
             :localizedBody LocalizedString}}
  
  Adds a message to the transit object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitObject/{resourceId}/addMessage"
     #{:resourceId}
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

(defn get$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/transitobject/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the transit object with the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitObject/{resourceId}"
     #{:resourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/transitobject/list
  
  Required parameters: none
  
  Optional parameters: token, maxResults, classId
  
  Returns a list of all transit objects for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitObject"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/transitobject/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:ticketStatus string,
   :purchaseDetails {:ticketCost TicketCost,
                     :purchaseReceiptNumber string,
                     :accountId string,
                     :purchaseDateTime string,
                     :confirmationCode string},
   :ticketLegs [{:originName LocalizedString,
                 :destinationName LocalizedString,
                 :zone string,
                 :originStationCode string,
                 :transitOperatorName LocalizedString,
                 :ticketSeats [TicketSeat],
                 :transitTerminusName LocalizedString,
                 :destinationStationCode string,
                 :arrivalDateTime string,
                 :departureDateTime string,
                 :ticketSeat TicketSeat,
                 :fareName LocalizedString,
                 :platform string,
                 :carriage string}],
   :hasUsers boolean,
   :smartTapRedemptionValue string,
   :rotatingBarcode {:totpDetails RotatingBarcodeTotpDetails,
                     :initialRotatingBarcodeValues RotatingBarcodeValues,
                     :showCodeText LocalizedString,
                     :type string,
                     :valuePattern string,
                     :alternateText string,
                     :renderEncoding string},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :tripType string,
   :barcode {:alternateText string,
             :showCodeText LocalizedString,
             :type string,
             :renderEncoding string,
             :value string,
             :kind string},
   :passengerType string,
   :hasLinkedDevice boolean,
   :groupingInfo {:groupingId string, :sortIndex integer},
   :state string,
   :customConcessionCategory {:defaultValue TranslatedString,
                              :translatedValues [TranslatedString],
                              :kind string},
   :classReference {:wordMark Image,
                    :transitType string,
                    :customFareNameLabel LocalizedString,
                    :customDiscountMessageLabel LocalizedString,
                    :customPlatformLabel LocalizedString,
                    :reviewStatus string,
                    :customRouteRestrictionsDetailsLabel LocalizedString,
                    :customCarriageLabel LocalizedString,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :customZoneLabel LocalizedString,
                    :customFareClassLabel LocalizedString,
                    :customPurchaseReceiptNumberLabel LocalizedString,
                    :logo Image,
                    :activationOptions ActivationOptions,
                    :enableSingleLegItinerary boolean,
                    :wideLogo Image,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :transitOperatorName LocalizedString,
                    :homepageUri Uri,
                    :customConcessionCategoryLabel LocalizedString,
                    :customSeatLabel LocalizedString,
                    :customTransitTerminusNameLabel LocalizedString,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :customRouteRestrictionsLabel LocalizedString,
                    :locations [LatLongPoint],
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :customTimeRestrictionsLabel LocalizedString,
                    :customOtherRestrictionsLabel LocalizedString,
                    :messages [Message],
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :review Review,
                    :id string,
                    :customPurchaseFaceValueLabel LocalizedString,
                    :customConfirmationCodeLabel LocalizedString,
                    :customCoachLabel LocalizedString,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :version string,
                    :customPurchasePriceLabel LocalizedString,
                    :viewUnlockRequirement string,
                    :infoModuleData InfoModuleData,
                    :heroImage Image,
                    :watermark Image,
                    :countryCode string,
                    :customTicketNumberLabel LocalizedString,
                    :languageOverride string},
   :disableExpirationNotification boolean,
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :ticketLeg {:originName LocalizedString,
               :destinationName LocalizedString,
               :zone string,
               :originStationCode string,
               :transitOperatorName LocalizedString,
               :ticketSeats [TicketSeat],
               :transitTerminusName LocalizedString,
               :destinationStationCode string,
               :arrivalDateTime string,
               :departureDateTime string,
               :ticketSeat TicketSeat,
               :fareName LocalizedString,
               :platform string,
               :carriage string},
   :validTimeInterval {:start DateTime, :kind string, :end DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :hexBackgroundColor string,
   :messages [{:body string,
               :messageType string,
               :header string,
               :id string,
               :kind string,
               :displayInterval TimeInterval,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString}],
   :ticketNumber string,
   :id string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :webAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :concessionCategory string,
   :passengerNames string,
   :ticketRestrictions {:timeRestrictions LocalizedString,
                        :otherRestrictions LocalizedString,
                        :routeRestrictionsDetails LocalizedString,
                        :routeRestrictions LocalizedString},
   :tripId string,
   :version string,
   :deviceContext {:deviceToken string},
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :customTicketStatus {:defaultValue TranslatedString,
                        :translatedValues [TranslatedString],
                        :kind string},
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :activationStatus {:state string}}
  
  Inserts an transit object with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitObject"
     #{}
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
