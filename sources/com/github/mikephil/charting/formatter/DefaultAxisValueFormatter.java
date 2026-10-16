package com.github.mikephil.charting.formatter;

import com.facebook.appevents.AppEventsConstants;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultAxisValueFormatter extends ValueFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected DecimalFormat f68560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f68561b;

    public DefaultAxisValueFormatter(int i3) {
        this.f68561b = i3;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        this.f68560a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String f(float f3) {
        return this.f68560a.format(f3);
    }

    public int j() {
        return this.f68561b;
    }
}
