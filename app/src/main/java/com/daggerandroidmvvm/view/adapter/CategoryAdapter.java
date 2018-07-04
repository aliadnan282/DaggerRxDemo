package com.daggerandroidmvvm.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daggerandroidmvvm.R;
import com.daggerandroidmvvm.data.entity.DailyExerciseProgress;
import com.daggerandroidmvvm.helper.AppPreference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AdnanAli on 3/8/2018.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.VHCategory> {
    private static final String TAG = CategoryAdapter.class.getSimpleName();
    private final AppPreference appPreference;
    LayoutInflater inflater;
    DaysClickListener listener;
    Context context;
    private List<DailyExerciseProgress> categoryList = new ArrayList<>();

    public CategoryAdapter(Context context, DaysClickListener daysClickListener) {
        this.context = context;
        this.listener = daysClickListener;
        inflater = LayoutInflater.from(context);
        appPreference = AppPreference.getInstance(context);
    }

    @Override
    public VHCategory onCreateViewHolder(ViewGroup parent, int viewType) {
       // CardVhDaysBinding cardVhCategory = DataBindingUtil.inflate(inflater, R.layout.card_vh_days, parent, false);
        View cardVhCategory = inflater.inflate(R.layout.card_vh_days, parent, false);
        return new VHCategory(cardVhCategory);
    }


    @Override
    public void onBindViewHolder(VHCategory holder, int position) {
        DailyExerciseProgress category = categoryList.get(position);
        holder.bind(category);

    }

    public void onPlanDaysClicked(View view, DailyExerciseProgress dayProgress) {
        listener.onDayClicked(dayProgress);

        // Day1 start exercise
    /*    if (!dayProgress.isDayComplete() && dayProgress.getDayId() == 1) {
            appPreference.setDay(dayProgress.getDayId());
            context.startActivity(new Intent(context, ExerciseListActivity.class));
        } else {
            // Day is greater than 1 so first check previous day wether complete or show toast message
            DailyExerciseProgress local = categoryList.get(dayProgress.getDayId() - 1);
            if (local.isDayComplete()) {
                appPreference.setDay(dayProgress.getDayId());
                if (dayProgress.getDayId() % 7 == 0)
                    context.startActivity(new Intent(context, RestActivity.class));
                else
                    context.startActivity(new Intent(context, ExerciseListActivity.class));
            } else {
                Toast.makeText(context, context.getString(R.string.complete_previous_days_first), Toast.LENGTH_SHORT).show();
            }
        }*/


    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void setPlanDays(List<DailyExerciseProgress> categories) {
        Log.d(TAG, "setCategories: size" + categories.size());
        categoryList = categories;
        notifyDataSetChanged();
    }

    public interface DaysClickListener {
        void onDayClicked(DailyExerciseProgress dayProgress);
    }

    class VHCategory extends RecyclerView.ViewHolder {


        //CardVhDaysBinding mBinding;

        VHCategory(View cardVhDaysBinding) {
            super(cardVhDaysBinding);
           // mBinding = cardVhDaysBinding;
        }

        void bind(DailyExerciseProgress planDays) {
           /* mBinding.setDailyExerciseProgress(planDays);
            // mBinding.setAdapter(CategoryAdapter.this);
            mBinding.executePendingBindings();*/

        }
    }
}
