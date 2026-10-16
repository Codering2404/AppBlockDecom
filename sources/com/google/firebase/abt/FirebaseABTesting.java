package com.google.firebase.abt;

import android.content.Context;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseABTesting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f87633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f87634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Integer f87635c = null;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface OriginService {
    }

    public FirebaseABTesting(Context context, Provider provider, String str) {
        this.f87633a = provider;
        this.f87634b = str;
    }

    private void a(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        ((AnalyticsConnector) this.f87633a.get()).a(conditionalUserProperty);
    }

    private void b(List list) {
        ArrayDeque arrayDeque = new ArrayDeque(f());
        int i3 = i();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbtExperimentInfo abtExperimentInfo = (AbtExperimentInfo) it.next();
            while (arrayDeque.size() >= i3) {
                k(((AnalyticsConnector.ConditionalUserProperty) arrayDeque.pollFirst()).f87658b);
            }
            AnalyticsConnector.ConditionalUserProperty conditionalUserPropertyF = abtExperimentInfo.f(this.f87634b);
            a(conditionalUserPropertyF);
            arrayDeque.offer(conditionalUserPropertyF);
        }
    }

    private static List c(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(AbtExperimentInfo.b((Map) it.next()));
        }
        return arrayList;
    }

    private boolean d(List list, AbtExperimentInfo abtExperimentInfo) {
        String strC = abtExperimentInfo.c();
        String strE = abtExperimentInfo.e();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbtExperimentInfo abtExperimentInfo2 = (AbtExperimentInfo) it.next();
            if (abtExperimentInfo2.c().equals(strC) && abtExperimentInfo2.e().equals(strE)) {
                return true;
            }
        }
        return false;
    }

    private List f() {
        return ((AnalyticsConnector) this.f87633a.get()).f(this.f87634b, "");
    }

    private ArrayList g(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbtExperimentInfo abtExperimentInfo = (AbtExperimentInfo) it.next();
            if (!d(list2, abtExperimentInfo)) {
                arrayList.add(abtExperimentInfo);
            }
        }
        return arrayList;
    }

    private ArrayList h(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbtExperimentInfo abtExperimentInfo = (AbtExperimentInfo) it.next();
            if (!d(list2, abtExperimentInfo)) {
                arrayList.add(abtExperimentInfo.f(this.f87634b));
            }
        }
        return arrayList;
    }

    private int i() {
        if (this.f87635c == null) {
            this.f87635c = Integer.valueOf(((AnalyticsConnector) this.f87633a.get()).e(this.f87634b));
        }
        return this.f87635c.intValue();
    }

    private void k(String str) {
        ((AnalyticsConnector) this.f87633a.get()).clearConditionalUserProperty(str, null, null);
    }

    private void l(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            k(((AnalyticsConnector.ConditionalUserProperty) it.next()).f87658b);
        }
    }

    private void n(List list) throws AbtException {
        if (list.isEmpty()) {
            j();
            return;
        }
        List listE = e();
        l(h(listE, list));
        b(g(list, listE));
    }

    private void o() throws AbtException {
        if (this.f87633a.get() == null) {
            throw new AbtException("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
        }
    }

    public List e() throws AbtException {
        o();
        List listF = f();
        ArrayList arrayList = new ArrayList();
        Iterator it = listF.iterator();
        while (it.hasNext()) {
            arrayList.add(AbtExperimentInfo.a((AnalyticsConnector.ConditionalUserProperty) it.next()));
        }
        return arrayList;
    }

    public void j() throws AbtException {
        o();
        l(f());
    }

    public void m(List list) throws AbtException {
        o();
        if (list == null) {
            throw new IllegalArgumentException("The replacementExperiments list is null.");
        }
        n(c(list));
    }
}
