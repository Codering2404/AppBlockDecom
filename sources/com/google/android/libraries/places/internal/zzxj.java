package com.google.android.libraries.places.internal;

import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzxj {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ImmutableSet f78821d = ImmutableSet.G("applet", "base", "embed", "math", "meta", "object", "svg", SDKConstants.PARAM_UPDATE_TEMPLATE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ImmutableSet f78822e = ImmutableSet.A("script");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ImmutableSet f78823f = ImmutableSet.A(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ImmutableSet f78824g = ImmutableSet.G("area", "br", "col", "hr", "img", "input", "link", "param", "source", "track", "wbr");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ImmutableSet f78825h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ImmutableSet f78826i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f78827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f78828b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f78829c = new ArrayList();

    static {
        ImmutableSet.A("input");
        ImmutableSet.A("form");
        ImmutableSet.A("script");
        ImmutableSet.B("button", "input");
        ImmutableSet.B("button", "input");
        f78825h = ImmutableSet.B("a", "area");
        f78826i = ImmutableSet.G("alternate", "author", "bookmark", "canonical", "cite", "help", "icon", "license", "next", "prefetch", "dns-prefetch", "prerender", "preconnect", "preload", "prev", "search", "subresource");
        ImmutableSet.A("form");
        ImmutableSet.A("input");
        ImmutableSet.B("input", "textarea");
        ImmutableSet.E("audio", "img", "input", "source", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO);
        ImmutableSet.A("iframe");
    }

    public zzxj(String str) {
        if (!"a".matches("[a-z0-9-]+")) {
            throw new IllegalArgumentException("Invalid element name \"a\". Only lowercase letters, numbers and '-' allowed.");
        }
        if (f78821d.contains("a")) {
            throw new IllegalArgumentException("Element \"a\" is not supported.");
        }
        this.f78827a = "a";
    }

    public final zzxj a(zzxl zzxlVar) {
        String str;
        ImmutableSet immutableSet = f78825h;
        String str2 = this.f78827a;
        if (!immutableSet.contains(str2) && !str2.equals("link")) {
            throw new IllegalArgumentException("Attribute \"href\" with a SafeUrl value can only be used by one of the following elements: ".concat(String.valueOf(immutableSet)));
        }
        if (!str2.equals("link") || (str = (String) this.f78828b.get("rel")) == null || f78826i.contains(str.toLowerCase(Locale.ENGLISH))) {
            String strA = zzxlVar.a();
            Map map = this.f78828b;
            int i3 = zzxg.f78794b;
            map.put(ShareConstants.WEB_DIALOG_PARAM_HREF, zzaub.b(strA, 65533));
            return this;
        }
        StringBuilder sb = new StringBuilder(str.length() + 113);
        sb.append("SafeUrl values for the href attribute are not allowed on <link rel=");
        sb.append(str);
        sb.append(">. Did you intend to use a TrustedResourceUrl?");
        throw new IllegalArgumentException(sb.toString());
    }

    public final zzxj b(String str) {
        Iterator it = Arrays.asList(zzxk.a(str)).iterator();
        ImmutableSet immutableSet = f78824g;
        String str2 = this.f78827a;
        Preconditions.D(!immutableSet.contains(str2), "Element \"%s\" is a void element and so cannot have content.", str2);
        Preconditions.D(!f78822e.contains(str2), "Element \"%s\" requires SafeScript contents, not SafeHTML or text.", str2);
        Preconditions.D(!f78823f.contains(str2), "Element \"%s\" requires SafeStyleSheet contents, not SafeHTML or text.", str2);
        while (it.hasNext()) {
            this.f78829c.add(((zzxi) it.next()).a());
        }
        return this;
    }

    public final zzxi c() {
        StringBuilder sb = new StringBuilder("<");
        String str = this.f78827a;
        sb.append(str);
        for (Map.Entry entry : this.f78828b.entrySet()) {
            sb.append(KLAQHFCRAUejH.ejoPWmHODXK);
            sb.append((String) entry.getKey());
            sb.append("=\"");
            sb.append(zzxg.a((String) entry.getValue()));
            sb.append("\"");
        }
        boolean zContains = f78824g.contains(str);
        sb.append(">");
        if (!zContains) {
            Iterator it = this.f78829c.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
            }
            sb.append("</");
            sb.append(str);
            sb.append(">");
        }
        return new zzxi(sb.toString());
    }
}
