package com.applovin.impl;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class mq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DateFormat f61923a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Random f61924b = new Random(System.currentTimeMillis());

    private static Set a(Set set, List list, eq eqVar, com.applovin.impl.sdk.j jVar) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                kq kqVarA = kq.a((es) it.next(), eqVar, jVar);
                if (kqVarA != null) {
                    set.add(kqVarA);
                }
            }
        }
        return set;
    }

    public static boolean b(aq aqVar) {
        nq nqVarV1;
        List listG;
        return (aqVar == null || (nqVarV1 = aqVar.v1()) == null || (listG = nqVarV1.g()) == null || listG.isEmpty()) ? false : true;
    }

    public static fq c(aq aqVar) {
        if (b(aqVar) || a(aqVar)) {
            return null;
        }
        return fq.GENERAL_WRAPPER_ERROR;
    }

    public static String a(es esVar, String str, String str2) {
        es esVarC = esVar.c(str);
        if (esVarC != null) {
            String strD = esVarC.d();
            if (StringUtils.isValidString(strD)) {
                return strD;
            }
        }
        return str2;
    }

    public static boolean b(es esVar) {
        if (esVar != null) {
            return esVar.b("Wrapper") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains a wrapper response");
    }

    private static String b() {
        DateFormat dateFormat = f61923a;
        dateFormat.setTimeZone(TimeZone.getDefault());
        return dateFormat.format(new Date());
    }

    public static void a(Set set, long j3, Uri uri, fq fqVar, com.applovin.impl.sdk.j jVar) {
        if (jVar != null) {
            if (set == null || set.isEmpty()) {
                return;
            }
            Iterator it = set.iterator();
            while (it.hasNext()) {
                long j4 = j3;
                Uri uri2 = uri;
                fq fqVar2 = fqVar;
                com.applovin.impl.sdk.j jVar2 = jVar;
                Uri uriA = a(((kq) it.next()).c(), j4, uri2, fqVar2, jVar2);
                if (uriA != null) {
                    jVar2.W().a(com.applovin.impl.sdk.network.d.b().d(uriA.toString()).a(false).a(), false);
                }
                j3 = j4;
                uri = uri2;
                fqVar = fqVar2;
                jVar = jVar2;
            }
            return;
        }
        throw new IllegalArgumentException("Unable to fire trackers. No sdk specified.");
    }

    public static void a(Set set, fq fqVar, com.applovin.impl.sdk.j jVar) {
        a(set, -1L, (Uri) null, fqVar, jVar);
    }

    public static void a(Set set, com.applovin.impl.sdk.j jVar) {
        a(set, -1L, (Uri) null, fq.UNSPECIFIED, jVar);
    }

    private static String a(long j3) {
        if (j3 > 0) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long hours = timeUnit.toHours(j3);
            long minutes = timeUnit.toMinutes(j3);
            TimeUnit timeUnit2 = TimeUnit.MINUTES;
            return String.format(Locale.US, "%02d:%02d:%02d.000", Long.valueOf(hours), Long.valueOf(minutes % timeUnit2.toSeconds(1L)), Long.valueOf(j3 % timeUnit2.toSeconds(1L)));
        }
        return "00:00:00.000";
    }

    public static String a(eq eqVar) {
        es esVarB;
        if (eqVar != null) {
            List listA = eqVar.a();
            int size = eqVar.a().size();
            if (size <= 0 || (esVarB = ((es) listA.get(size - 1)).b("VASTAdTagURI")) == null) {
                return null;
            }
            return esVarB.d();
        }
        throw new IllegalArgumentException("Unable to get resolution uri string for fetching the next wrapper or inline response in the chain");
    }

    public static void a(eq eqVar, AppLovinAdLoadListener appLovinAdLoadListener, fq fqVar, int i3, com.applovin.impl.sdk.j jVar) {
        if (jVar != null) {
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(i3);
            }
            a(a(eqVar, jVar), fqVar, jVar);
            return;
        }
        throw new IllegalArgumentException("Unable to handle failure. No sdk specified.");
    }

    public static boolean a(aq aqVar) {
        dq dqVarL1;
        iq iqVarE;
        if (aqVar == null || (dqVarL1 = aqVar.l1()) == null || (iqVarE = dqVarL1.e()) == null) {
            return false;
        }
        return iqVarE.c() != null || StringUtils.isValidString(iqVarE.b());
    }

    public static boolean a(es esVar) {
        if (esVar != null) {
            return esVar.b("InLine") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains an inline response");
    }

    public static void a(es esVar, Map map, eq eqVar, com.applovin.impl.sdk.j jVar) {
        List<es> listA;
        if (jVar == null) {
            throw new IllegalArgumentException("Unable to render event trackers. No sdk specified.");
        }
        if (esVar == null) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().b("VastUtils", "Unable to render event trackers; null node provided");
                return;
            }
            return;
        }
        if (map == null) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().b("VastUtils", "Unable to render event trackers; null event trackers provided");
                return;
            }
            return;
        }
        es esVarC = esVar.c("TrackingEvents");
        if (esVarC == null || (listA = esVarC.a("Tracking")) == null) {
            return;
        }
        for (es esVar2 : listA) {
            String str = (String) esVar2.a().get("event");
            if (StringUtils.isValidString(str)) {
                kq kqVarA = kq.a(esVar2, eqVar, jVar);
                if (kqVarA != null) {
                    Set set = (Set) map.get(str);
                    if (set != null) {
                        set.add(kqVarA);
                    } else {
                        HashSet hashSet = new HashSet();
                        hashSet.add(kqVarA);
                        map.put(str, hashSet);
                    }
                }
            } else {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().b("VastUtils", "Could not find event for tracking node = " + esVar2);
                }
            }
        }
    }

    public static void a(List list, Set set, eq eqVar, com.applovin.impl.sdk.j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("Unable to render trackers. No sdk specified.");
        }
        if (list == null) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().b("VastUtils", "Unable to render trackers; null nodes provided");
                return;
            }
            return;
        }
        if (set == null) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().b("VastUtils", "Unable to render trackers; null trackers provided");
                return;
            }
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            kq kqVarA = kq.a((es) it.next(), eqVar, jVar);
            if (kqVarA != null) {
                set.add(kqVarA);
            }
        }
    }

    public static Uri a(String str, long j3, Uri uri, fq fqVar, com.applovin.impl.sdk.j jVar) {
        if (URLUtil.isValidUrl(str)) {
            try {
                String string = Integer.toString(fqVar.b());
                String strReplace = str.replace("[ERRORCODE]", string).replace("[REASON]", string);
                if (j3 >= 0) {
                    strReplace = strReplace.replace("[CONTENTPLAYHEAD]", a(j3));
                }
                if (uri != null) {
                    strReplace = strReplace.replace("[ASSETURI]", uri.toString());
                }
                return Uri.parse(strReplace.replace("[CACHEBUSTING]", a()).replace("[TIMESTAMP]", b()));
            } catch (Throwable th) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("VastUtils", "Unable to replace macros in URL string " + str, th);
                }
                jVar.D().a("VastUtils", th);
                return null;
            }
        }
        jVar.I();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.I().b("VastUtils", "Unable to replace macros in invalid URL string.");
        }
        return null;
    }

    private static Set a(eq eqVar, com.applovin.impl.sdk.j jVar) {
        if (eqVar == null) {
            return null;
        }
        List<es> listA = eqVar.a();
        Set hashSet = new HashSet(listA.size());
        for (es esVar : listA) {
            es esVarB = esVar.b("Wrapper");
            if (esVarB == null) {
                esVarB = esVar.b("InLine");
            }
            if (esVarB != null) {
                hashSet = a(hashSet, esVarB.a("Error"), eqVar, jVar);
            } else {
                hashSet = a(hashSet, esVar.a("Error"), eqVar, jVar);
            }
        }
        jVar.I();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.I().a("VastUtils", "Retrieved " + hashSet.size() + " top level error trackers: " + hashSet);
        }
        return hashSet;
    }

    private static String a() {
        return Integer.toString(f61924b.nextInt(89999999) + 10000000);
    }
}
