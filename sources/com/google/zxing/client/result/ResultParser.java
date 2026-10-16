package com.google.zxing.client.result;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ResultParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ResultParser[] f91745a = {new BookmarkDoCoMoResultParser(), new AddressBookDoCoMoResultParser(), new EmailDoCoMoResultParser(), new AddressBookAUResultParser(), new VCardResultParser(), new BizcardResultParser(), new VEventResultParser(), new EmailAddressResultParser(), new SMTPResultParser(), new TelResultParser(), new SMSMMSResultParser(), new SMSTOMMSTOResultParser(), new GeoResultParser(), new WifiResultParser(), new URLTOResultParser(), new URIResultParser(), new ISBNResultParser(), new ProductResultParser(), new ExpandedProductResultParser(), new VINResultParser()};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f91746b = Pattern.compile("\\d+");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f91747c = Pattern.compile("&");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f91748d = Pattern.compile("=");
}
