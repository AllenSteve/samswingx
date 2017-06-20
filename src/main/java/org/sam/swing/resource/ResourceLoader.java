package org.sam.swing.resource;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 资源加载对象
 * 只加载一次
 * @author sam
 *
 */
public class ResourceLoader
{
	
	//begin constant resource
	
	/**
	 * 工具栏图标
	 */
	public static final String IMAGE_STATIC = "org/sam/swing/resource/iconfont-stack2.png";
	
	/**
	 * 监视器图标
	 */
	public static final String IMAGE_MONITOR = "org/sam/swing/resource/iconfont-monitor.png";
	
	/**
	 * 播放图标
	 */
	public static final String IMAGE_PLAY = "org/sam/swing/resource/Play16x16.png";
	
	/**
	 * 暂停图标
	 */
	public static final String IMAGE_PAUSE = "org/sam/swing/resource/Pause16x16.png";
	
	/**
	 * 停止按钮
	 */
	public static final String IMAGE_STOP = "org/sam/swing/resource/Stop16x16.png";
	
	/**
	 * 停止动画按钮
	 */
	public static final String IMAGE_STOP_PRESS = "org/sam/swing/resource/StopPress16x16.png";
	
	/**
	 * 开始仿真图标
	 */
	public static final String IMAGE_START_SIMULATOR = "org/sam/swing/resource/export.png";
	
	/**
	 * 停止仿真图标
	 */
	public static final String IMAGE_STOP_SIMULATOR = "org/sam/swing/resource/exit.png";
	
	/**
	 * 打开功能树窗口图标
	 */
	public static final String IMAGE_OPEN_NAVIGATION = "org/sam/swing/resource/large_clipart.png";
	
	/**
	 * 打开仿真窗口图标
	 */
	public static final String IMAGE_OPEN_SIMULATOR = "org/sam/swing/resource/Nitrogen.png";
	
	/**
	 * 打开图层窗口图标
	 */
	public static final String IMAGE_OPEN_LAYER = "org/sam/swing/resource/add.png";
	
	/**
	 * 打开日志窗口图标
	 */
	public static final String IMAGE_OPEN_LOG = "org/sam/swing/resource/filter.png";
	
	/**
	 * 打开图层窗口图标
	 */
	public static final String IMAGE_RETRIEVE = "org/sam/swing/resource/filter.png";
	
	/**
	 * 新增操作按钮
	 */
	public static final String IMAGE_NEW = "org/sam/swing/resource/new.png";
	
	/**
	 * 新增操作按钮
	 */
	public static final String IMAGE_ADD_SMALL = "org/sam/swing/resource/edit_add.png";
	
	/**
	 * 移除操作小图片
	 */
	public static final String IMAGE_DEL_SMALL = "org/sam/swing/resource/edit_remove.png";
	
	/**
	 * 移除操作小图片
	 */
	public static final String IMAGE_INSERT_SMALL = "org/sam/swing/resource/insert.png";
	
	/**
	 * 修改按钮
	 */
	public static final String IMAGE_MODIFY = "org/sam/swing/resource/modify.png";
	
	/**
	 * 删除按钮
	 */
	public static final String IMAGE_DELETE = "org/sam/swing/resource/delete.png";
	
	/**
	 * 保存按钮
	 */
	public static final String IMAGE_SAVE = "org/sam/swing/resource/save.png";
	
	/**
	 * 导入图片
	 */
	public static final String IMAGE_IMPORT = "org/sam/swing/resource/large_smartart.png";
	
	/**
	 * 导出图片
	 */
	public static final String IMAGE_EXPORT = "org/sam/swing/resource/large_shapes.png";
	
	/**
	 * 上移图片
	 */
	public static final String IMAGE_UP = "org/sam/swing/resource/upenable.png";
	
	/**
	 * 下移图片
	 */
	public static final String IMAGE_DOWN = "org/sam/swing/resource/downenable.png";
	
	/**
	 * 查询图片
	 */
	public static final String IMAGE_FIND = "org/sam/swing/resource/find.png";
	
	/**
	 * 程序的logo
	 */
	public static final String IMAGE_LOGO = "org/sam/swing/resource/logo.png";
	
	/**
	 * 打开shp图层的操作
	 */
	public static final String IMAGE_GEO_OPEN_SHP = "org/sam/swing/resource/OpenLayer.png";
	
	/**
	 * 连接到数据库的图标
	 */
	public static final String IMAGE_GEO_CONNECT_DB = "org/sam/swing/resource/connectdb.png";
	
	/**
	 * 选中图元对象的图标
	 */
	public static final String IMAGE_GEO_SELECTOR = "org/sam/swing/resource/selectgeo.png";
	
	/**
	 * 图层数据集合
	 */
	public static final String IMAGE_GEO_DATASTORE = "org/sam/swing/resource/datastore.png";
	
	/**
	 * 选中数据集合
	 */
	public static final String IMAGE_GEO_SELECTDATASTORE = "org/sam/swing/resource/selecteddatastore.png";
	
	/**
	 * 新增点的图片
	 */
	public static final String IMAGE_POINT_ADD = "org/sam/swing/resource/point.png";
	
	/**
	 * 线条的图片
	 */
	public static final String IMAGE_LINE = "org/sam/swing/resource/line.png";
	
	/**
	 * 多边形的图片
	 */
	public static final String IMAGE_POLYGON = "org/sam/swing/resource/polygon.png";
	
	/**
	 * 开始编辑的图片
	 */
	public static final String IMAGE_EDIT_BEGIN = "org/sam/swing/resource/geoedit.png";
	
	/**
	 * 结束编辑的图片
	 */
	public static final String IMAGE_EDIT_END = "org/sam/swing/resource/geosave.png"; 
	
	/**
	 * 选择地理信息对象图片
	 */
	public static final String IMAGE_GEO_SELECT = "org/sam/swing/resource/selectgeo.png";
	/**
	 * 简单选择对象
	 */
	public static final String IMAGE_GEO_SIMPLE_SELECT = "org/sam/swing/resource/pointer.png";
	/**
	 * 移除点的图片
	 */
	public static final String IMAGE_GEO_REMOVE = "org/sam/swing/resource/removegeo.png";
	/**
	 * 编辑物理跑道图标
	 */
	public static final String IMAGE_ADD_RUNWAY = "org/sam/swing/resource/runway.png";
	/**
	 * 编辑逻辑跑道图标
	 */
	public static final String IMAGE_ADD_RUNWAY_LOGIC = "org/sam/swing/resource/runwayLogic.png";
	/**
	 * 地面点
	 */
	public static final String IMAGE_ADD_GROUND_POINT = "org/sam/swing/resource/groundPoint.png";
	
	/**
	 * 滑行道编辑按钮
	 */
	public static final String IMAGE_ADD_TAXIWAY = "org/sam/swing/resource/taxiway.png";
	
	/**
	 * 延长线功能
	 */
	public static final String IMAGE_GEO_EXTENSION_LINE = "org/sam/swing/resource/extension-line.png";
	
	/**
	 * 停机位编辑按钮
	 */
	public static final String IMAGE_ADD_PARKINGPOINT = "org/sam/swing/resource/parkingPoint.png";
			
	/**
	 * 跑道入口编辑按钮
	 */
	public static final String IMAGE_ADD_RUNWAYENTRY = "org/sam/swing/resource/runwayEntry.png";
	
	/**
	 * 跑道出口编辑按钮
	 */
	public static final String IMAGE_ADD_RUNWAYEXIT = "org/sam/swing/resource/runwayExit.png";
	
	//end
	
	/**
	 * 已加载的资源文件列表
	 */
	protected static Map<String , URL> resources = new HashMap<>();
	
	/**
	 * 获取资源文件
	 * @param name 资源名称
	 * @return 资源链接地址
	 */
	public static URL getResource(String name)
	{
		if (!resources.containsKey(name))
		{
			synchronized (resources) 
			{
				resources.put(name, ResourceLoader.class.getClassLoader().getResource(name));
			}
		}
		
		return resources.get(name);
	}
	
	/**
	 * 以流的方式获取资源
	 * @param name 资源名称 
	 * @return 
	 */
	public static InputStream getResourceStream(String name)
	{	
		return ResourceLoader.class.getClassLoader().getResourceAsStream(name);
	}
}
