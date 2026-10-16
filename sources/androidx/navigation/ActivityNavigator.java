package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.Navigator;
import androidx.savedstate.SavedStateReader;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Navigator.Name("activity")
@Metadata
public class ActivityNavigator extends Navigator<Destination> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f48745f = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f48746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Activity f48747e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class Destination extends NavDestination {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Intent f48748i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f48749j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Destination(Navigator activityNavigator) {
            super(activityNavigator);
            Intrinsics.checkNotNullParameter(activityNavigator, "activityNavigator");
        }

        private final String L(Context context, String str) {
            if (str == null) {
                return null;
            }
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            return StringsKt.O(str, "${applicationId}", packageName, false, 4, null);
        }

        @Override // androidx.navigation.NavDestination
        public boolean G() {
            return false;
        }

        public final String H() {
            Intent intent = this.f48748i;
            if (intent != null) {
                return intent.getAction();
            }
            return null;
        }

        public final ComponentName I() {
            Intent intent = this.f48748i;
            if (intent != null) {
                return intent.getComponent();
            }
            return null;
        }

        public final String J() {
            return this.f48749j;
        }

        public final Intent K() {
            return this.f48748i;
        }

        public final Destination M(String str) {
            if (this.f48748i == null) {
                this.f48748i = new Intent();
            }
            Intent intent = this.f48748i;
            Intrinsics.checkNotNull(intent);
            intent.setAction(str);
            return this;
        }

        public final Destination N(ComponentName componentName) {
            if (this.f48748i == null) {
                this.f48748i = new Intent();
            }
            Intent intent = this.f48748i;
            Intrinsics.checkNotNull(intent);
            intent.setComponent(componentName);
            return this;
        }

        public final Destination O(Uri uri) {
            if (this.f48748i == null) {
                this.f48748i = new Intent();
            }
            Intent intent = this.f48748i;
            Intrinsics.checkNotNull(intent);
            intent.setData(uri);
            return this;
        }

        public final Destination P(String str) {
            this.f48749j = str;
            return this;
        }

        public final Destination Q(String str) {
            if (this.f48748i == null) {
                this.f48748i = new Intent();
            }
            Intent intent = this.f48748i;
            Intrinsics.checkNotNull(intent);
            intent.setPackage(str);
            return this;
        }

        @Override // androidx.navigation.NavDestination
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof Destination) && super.equals(obj)) {
                Intent intent = this.f48748i;
                if ((intent != null ? intent.filterEquals(((Destination) obj).f48748i) : ((Destination) obj).f48748i == null) && Intrinsics.areEqual(this.f48749j, ((Destination) obj).f48749j)) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.navigation.NavDestination
        public int hashCode() {
            int iHashCode = super.hashCode() * 31;
            Intent intent = this.f48748i;
            int iFilterHashCode = (iHashCode + (intent != null ? intent.filterHashCode() : 0)) * 31;
            String str = this.f48749j;
            return iFilterHashCode + (str != null ? str.hashCode() : 0);
        }

        @Override // androidx.navigation.NavDestination
        public String toString() {
            ComponentName componentNameI = I();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (componentNameI != null) {
                sb.append(" class=");
                sb.append(componentNameI.getClassName());
            } else {
                String strH = H();
                if (strH != null) {
                    sb.append(" action=");
                    sb.append(strH);
                }
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        @Override // androidx.navigation.NavDestination
        public void x(Context context, AttributeSet attrs) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            super.x(context, attrs);
            TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, R.styleable.f48997a);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainAttributes, "obtainAttributes(...)");
            Q(L(context, typedArrayObtainAttributes.getString(R.styleable.f49002f)));
            String string = typedArrayObtainAttributes.getString(R.styleable.f48998b);
            if (string != null) {
                if (string.charAt(0) == '.') {
                    string = context.getPackageName() + string;
                }
                N(new ComponentName(context, string));
            }
            M(typedArrayObtainAttributes.getString(R.styleable.f48999c));
            String strL = L(context, typedArrayObtainAttributes.getString(R.styleable.f49000d));
            if (strL != null) {
                O(Uri.parse(strL));
            }
            P(L(context, typedArrayObtainAttributes.getString(R.styleable.f49001e)));
            typedArrayObtainAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Extras implements Navigator.Extras {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f48750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ActivityOptionsCompat f48751b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Builder {
        }

        public final ActivityOptionsCompat a() {
            return this.f48751b;
        }

        public final int b() {
            return this.f48750a;
        }
    }

    public ActivityNavigator(Context context) {
        Object next;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f48746d = context;
        Iterator it = SequencesKt.h(context, new Function1() { // from class: androidx.navigation.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ActivityNavigator.r((Context) obj);
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Context) next) instanceof Activity) {
                    break;
                }
            }
        }
        this.f48747e = (Activity) next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Context r(Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof ContextWrapper) {
            return ((ContextWrapper) it).getBaseContext();
        }
        return null;
    }

    @Override // androidx.navigation.Navigator
    public boolean o() {
        Activity activity = this.f48747e;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }

    @Override // androidx.navigation.Navigator
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Destination c() {
        return new Destination(this);
    }

    @Override // androidx.navigation.Navigator
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public NavDestination f(Destination destination, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        ActivityOptionsCompat activityOptionsCompatA;
        Intent intent;
        int intExtra;
        String strEncode;
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination.K() == null) {
            throw new IllegalStateException(("Destination " + destination.o() + " does not have an Intent set.").toString());
        }
        Intent intent2 = new Intent(destination.K());
        if (bundle != null) {
            intent2.putExtras(bundle);
            String strJ = destination.J();
            if (strJ != null && strJ.length() != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(strJ);
                while (matcher.find()) {
                    Bundle bundleA = SavedStateReader.a(bundle);
                    String strGroup = matcher.group(1);
                    Intrinsics.checkNotNull(strGroup);
                    if (!SavedStateReader.b(bundleA, strGroup)) {
                        throw new IllegalArgumentException(("Could not find " + strGroup + " in " + bundle + " to fill data pattern " + strJ).toString());
                    }
                    matcher.appendReplacement(stringBuffer, "");
                    NavArgument navArgument = (NavArgument) destination.h().get(strGroup);
                    NavType navTypeA = navArgument != null ? navArgument.a() : null;
                    if (navTypeA == null || (strEncode = navTypeA.i(navTypeA.a(bundle, strGroup))) == null) {
                        strEncode = Uri.encode(String.valueOf(bundle.get(strGroup)));
                    }
                    stringBuffer.append(strEncode);
                }
                matcher.appendTail(stringBuffer);
                intent2.setData(Uri.parse(stringBuffer.toString()));
            }
        }
        boolean z2 = extras instanceof Extras;
        if (z2) {
            intent2.addFlags(((Extras) extras).b());
        }
        if (this.f48747e == null) {
            intent2.addFlags(268435456);
        }
        if (navOptions != null && navOptions.j()) {
            intent2.addFlags(536870912);
        }
        Activity activity = this.f48747e;
        if (activity != null && (intent = activity.getIntent()) != null && (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) != 0) {
            intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
        }
        intent2.putExtra("android-support-navigation:ActivityNavigator:current", destination.o());
        Resources resources = this.f48746d.getResources();
        if (navOptions != null) {
            int iC = navOptions.c();
            int iD = navOptions.d();
            if ((iC <= 0 || !Intrinsics.areEqual(resources.getResourceTypeName(iC), "animator")) && (iD <= 0 || !Intrinsics.areEqual(resources.getResourceTypeName(iD), "animator"))) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", iC);
                Intrinsics.checkNotNull(intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", iD));
            } else {
                Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring popEnter resource " + resources.getResourceName(iC) + " and popExit resource " + resources.getResourceName(iD) + " when launching " + destination);
            }
        }
        if (!z2 || (activityOptionsCompatA = ((Extras) extras).a()) == null) {
            this.f48746d.startActivity(intent2);
        } else {
            ContextCompat.startActivity(this.f48746d, intent2, activityOptionsCompatA.b());
        }
        if (navOptions != null && this.f48747e != null) {
            int iA = navOptions.a();
            int iB = navOptions.b();
            if ((iA > 0 && Intrinsics.areEqual(resources.getResourceTypeName(iA), "animator")) || (iB > 0 && Intrinsics.areEqual(resources.getResourceTypeName(iB), "animator"))) {
                Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring enter resource " + resources.getResourceName(iA) + " and exit resource " + resources.getResourceName(iB) + "when launching " + destination);
            } else if (iA >= 0 || iB >= 0) {
                this.f48747e.overridePendingTransition(RangesKt.f(iA, 0), RangesKt.f(iB, 0));
            }
        }
        return null;
    }
}
