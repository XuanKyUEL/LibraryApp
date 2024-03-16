package mnxk.mcommerce.librarydemo02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.R.id;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

import mnxk.mcommerce.librarydemo02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setActionBar(binding.toolbar);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//
//        // set custom layout for the search view
//        assert searchView != null;
//        LinearLayout searchPlate = searchView.findViewById(id.search_edit_frame);
//        LayoutInflater inflater = LayoutInflater.from(searchPlate.getContext());
//        View searchPlateView = inflater.inflate(R.layout.custom_search_view, searchPlate, false);
//        searchPlate.removeAllViews();
//        searchPlate.addView(searchPlateView);
//        // set the hint for the search view
//        searchView.setQueryHint("Search");
//        searchItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
//            @Override
//            public boolean onMenuItemActionExpand(@NonNull MenuItem item) {
//                // do something when the search view is expanded
//                return true;
//            }
//
//            @Override
//            public boolean onMenuItemActionCollapse(@NonNull MenuItem item) {
//                // do something when the search view is collapsed
//                return true;
//            }
//        });
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.action_search) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    private void setActionBar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        // set the title of the action bar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowTitleEnabled(false);
        TextView title = toolbar.findViewById(R.id.tv_title);
        title.setText("Hello Xuân Kỳ");
        SearchView searchView = toolbar.findViewById(R.id.search_view);
        searchView.setQueryHint("Search your book");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(@NonNull String query) {
                // do something when the search button is clicked
                return true;
            }

            @Override
            public boolean onQueryTextChange(@NonNull String newText) {
                // do something when the text of the search view is changed
                return true;
            }
        });
        searchView.setOnSearchClickListener(v -> {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) searchView.getLayoutParams();
            LinearLayout.LayoutParams titleParams = (LinearLayout.LayoutParams) title.getLayoutParams();
            // change weight of the search view
            params.weight = 2.0f;
            titleParams.weight = 1.0f;
            // reassign the layout params
            searchView.setLayoutParams(params);
            title.setLayoutParams(titleParams);
        });
        searchView.setOnCloseListener(() -> {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) searchView.getLayoutParams();
            LinearLayout.LayoutParams titleParams = (LinearLayout.LayoutParams) title.getLayoutParams();
            // change weight of the search view
            params.weight = 1.0f;
            titleParams.weight = 9.0f;
            // reassign the layout params
            searchView.setLayoutParams(params);
            title.setLayoutParams(titleParams);
            return false;
        });
    }
}

