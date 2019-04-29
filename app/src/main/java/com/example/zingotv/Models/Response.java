package com.example.zingotv.Models;
import com.example.zingotv.Models.Converters.DataTypeconverterAuth;
import com.example.zingotv.Models.Converters.DataTypeconverterFilterDetails;
import com.example.zingotv.Models.Converters.DataTypeconverterMenu;
import java.util.List;
import androidx.room.Embedded;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

public class Response {
    private String type;
    private String showDetails;
    @Embedded
    private DetailsInfo detailsInfo;
    private String contentView;
    private String layout;
    private Boolean showPlayer;
    private Boolean directPlay;
    @Embedded(prefix = "layout_")
    private LayoutItems layoutItem;
    private int pageRefreshTime;
    private boolean showFilter;
    private boolean showFilterDetails;
    private boolean showFavourites;
    private boolean showMenuItems;
    @TypeConverters(DataTypeconverterMenu.class)
    private List<MenuItems> menuItems;
    @TypeConverters(DataTypeconverterAuth.class)
    private List<AuthButtons> authButtons;
    private boolean showCategoryHeader;
    private String showCategoryInfo;
    @Embedded
    private CustomerInfo customerInfo;
    @TypeConverters(DataTypeconverterFilterDetails.class)
    private List<FilterDetails> filterDetails;
    @Embedded(prefix = "items")
    private Items items;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShowDetails() {
        return showDetails;
    }

    public void setShowDetails(String showDetails) {
        this.showDetails = showDetails;
    }

    public DetailsInfo getDetailsInfo() {
        return detailsInfo;
    }

    public void setDetailsInfo(DetailsInfo detailsInfo) {
        this.detailsInfo = detailsInfo;
    }

    public String getContentView() {
        return contentView;
    }

    public void setContentView(String contentView) {
        this.contentView = contentView;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public Boolean getShowPlayer() {
        return showPlayer;
    }

    public void setShowPlayer(Boolean showPlayer) {
        this.showPlayer = showPlayer;
    }

    public Boolean getDirectPlay() {
        return directPlay;
    }

    public void setDirectPlay(Boolean directPlay) {
        this.directPlay = directPlay;
    }

    public LayoutItems getLayoutItem() {
        return layoutItem;
    }

    public void setLayoutItem(LayoutItems layoutItem) {
        this.layoutItem = layoutItem;
    }

    public int getPageRefreshTime() {
        return pageRefreshTime;
    }

    public void setPageRefreshTime(int pageRefreshTime) {
        this.pageRefreshTime = pageRefreshTime;
    }

    public boolean isShowFilter() {
        return showFilter;
    }

    public void setShowFilter(boolean showFilter) {
        this.showFilter = showFilter;
    }

    public boolean isShowFilterDetails() {
        return showFilterDetails;
    }

    public void setShowFilterDetails(boolean showFilterDetails) {
        this.showFilterDetails = showFilterDetails;
    }

    public boolean isShowFavourites() {
        return showFavourites;
    }

    public void setShowFavourites(boolean showFavourites) {
        this.showFavourites = showFavourites;
    }

    public boolean isShowMenuItems() {
        return showMenuItems;
    }

    public void setShowMenuItems(boolean showMenuItems) {
        this.showMenuItems = showMenuItems;
    }

    public List<MenuItems> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItems> menuItems) {
        this.menuItems = menuItems;
    }

    public List<AuthButtons> getAuthButtons() {
        return authButtons;
    }

    public void setAuthButtons(List<AuthButtons> authButtons) {
        this.authButtons = authButtons;
    }

    public boolean isShowCategoryHeader() {
        return showCategoryHeader;
    }

    public void setShowCategoryHeader(boolean showCategoryHeader) {
        this.showCategoryHeader = showCategoryHeader;
    }

    public String getShowCategoryInfo() {
        return showCategoryInfo;
    }

    public void setShowCategoryInfo(String showCategoryInfo) {
        this.showCategoryInfo = showCategoryInfo;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public List<FilterDetails> getFilterDetails() {
        return filterDetails;
    }

    public void setFilterDetails(List<FilterDetails> filterDetails) {
        this.filterDetails = filterDetails;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}
