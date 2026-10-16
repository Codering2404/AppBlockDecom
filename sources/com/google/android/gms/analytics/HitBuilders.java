package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.gtm.zzfc;
import com.google.android.gms.internal.gtm.zzfu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class HitBuilders {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder a(Product product, String str) {
            super.a(product, str);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder b(Product product) {
            super.b(product);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder c(Promotion promotion) {
            super.c(promotion);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder g(ProductAction productAction) {
            super.g(productAction);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class EventBuilder extends HitBuilder<EventBuilder> {
        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder a(Product product, String str) {
            super.a(product, str);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder b(Product product) {
            super.b(product);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder c(Promotion promotion) {
            super.c(promotion);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder g(ProductAction productAction) {
            super.g(productAction);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            e("&t", "exception");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder a(Product product, String str) {
            super.a(product, str);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder b(Product product) {
            super.b(product);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder c(Promotion promotion) {
            super.c(promotion);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder g(ProductAction productAction) {
            super.g(productAction);
            return this;
        }

        public ExceptionBuilder h(String str) {
            e("&exd", str);
            return this;
        }

        public ExceptionBuilder i(boolean z2) {
            e("&exf", zzfu.zzc(z2));
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class HitBuilder<T extends HitBuilder> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ProductAction f70873b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f70872a = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Map f70874c = new HashMap();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final List f70875d = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final List f70876e = new ArrayList();

        protected HitBuilder() {
        }

        public HitBuilder a(Product product, String str) {
            if (product == null) {
                zzfc.zze("product should be non-null");
                return this;
            }
            if (str == null) {
                str = "";
            }
            if (!this.f70874c.containsKey(str)) {
                this.f70874c.put(str, new ArrayList());
            }
            ((List) this.f70874c.get(str)).add(product);
            return this;
        }

        public HitBuilder b(Product product) {
            if (product == null) {
                zzfc.zze("product should be non-null");
                return this;
            }
            this.f70876e.add(product);
            return this;
        }

        public HitBuilder c(Promotion promotion) {
            if (promotion == null) {
                zzfc.zze("promotion should be non-null");
                return this;
            }
            this.f70875d.add(promotion);
            return this;
        }

        public Map d() {
            HashMap map = new HashMap(this.f70872a);
            ProductAction productAction = this.f70873b;
            if (productAction != null) {
                map.putAll(productAction.j());
            }
            Iterator it = this.f70875d.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                map.putAll(((Promotion) it.next()).e(zzd.j(i3)));
                i3++;
            }
            Iterator it2 = this.f70876e.iterator();
            int i4 = 1;
            while (it2.hasNext()) {
                map.putAll(((Product) it2.next()).l(zzd.h(i4)));
                i4++;
            }
            int i5 = 1;
            for (Map.Entry entry : this.f70874c.entrySet()) {
                List list = (List) entry.getValue();
                String strE = zzd.e(i5);
                Iterator it3 = list.iterator();
                int i6 = 1;
                while (it3.hasNext()) {
                    map.putAll(((Product) it3.next()).l(strE.concat(zzd.g(i6))));
                    i6++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    map.put(strE.concat("nm"), (String) entry.getKey());
                }
                i5++;
            }
            return map;
        }

        public final HitBuilder e(String str, String str2) {
            if (str != null) {
                this.f70872a.put(str, str2);
                return this;
            }
            zzfc.zze("HitBuilder.set() called with a null paramName.");
            return this;
        }

        public final HitBuilder f(Map map) {
            if (map == null) {
                return this;
            }
            this.f70872a.putAll(new HashMap(map));
            return this;
        }

        public HitBuilder g(ProductAction productAction) {
            this.f70873b = productAction;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder a(Product product, String str) {
            super.a(product, str);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder b(Product product) {
            super.b(product);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder c(Promotion promotion) {
            super.c(promotion);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder g(ProductAction productAction) {
            super.g(productAction);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            e("&t", "screenview");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder a(Product product, String str) {
            super.a(product, str);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder b(Product product) {
            super.b(product);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder c(Promotion promotion) {
            super.c(promotion);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder g(ProductAction productAction) {
            super.g(productAction);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder a(Product product, String str) {
            super.a(product, str);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder b(Product product) {
            super.b(product);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder c(Promotion promotion) {
            super.c(promotion);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder g(ProductAction productAction) {
            super.g(productAction);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder a(Product product, String str) {
            super.a(product, str);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder b(Product product) {
            super.b(product);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder c(Promotion promotion) {
            super.c(promotion);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder g(ProductAction productAction) {
            super.g(productAction);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder a(Product product, String str) {
            super.a(product, str);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder b(Product product) {
            super.b(product);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder c(Promotion promotion) {
            super.c(promotion);
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public final /* bridge */ /* synthetic */ HitBuilder g(ProductAction productAction) {
            super.g(productAction);
            return this;
        }
    }
}
