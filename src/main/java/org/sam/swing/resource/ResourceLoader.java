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
	public static final String IMAGE_STATIC = "com/adcc/emu/client/resource/iconfont-stack2.png";
	
	/**
	 * 监视器图标
	 */
	public static final String IMAGE_MONITOR = "com/adcc/emu/client/resource/iconfont-monitor.png";
	
	/**
	 * 播放图标
	 */
	public static final String IMAGE_PLAY = "com/adcc/emu/client/resource/Play16x16.png";
	
	/**
	 * 暂停图标
	 */
	public static final String IMAGE_PAUSE = "com/adcc/emu/client/resource/Pause16x16.png";
	
	/**
	 * 停止按钮
	 */
	public static final String IMAGE_STOP = "com/adcc/emu/client/resource/Stop16x16.png";
	
	/**
	 * 停止动画按钮
	 */
	public static final String IMAGE_STOP_PRESS = "com/adcc/emu/client/resource/StopPress16x16.png";
	
	/**
	 * 开始仿真图标
	 */
	public static final String IMAGE_START_SIMULATOR = "com/adcc/emu/client/resource/export.png";
	
	/**
	 * 停止仿真图标
	 */
	public static final String IMAGE_STOP_SIMULATOR = "com/adcc/emu/client/resource/exit.png";
	
	/**
	 * 打开功能树窗口图标
	 */
	public static final String IMAGE_OPEN_NAVIGATION = "com/adcc/emu/client/resource/large_clipart.png";
	
	/**
	 * 打开仿真窗口图标
	 */
	public static final String IMAGE_OPEN_SIMULATOR = "com/adcc/emu/client/resource/Nitrogen.png";
	
	/**
	 * 打开图层窗口图标
	 */
	public static final String IMAGE_OPEN_LAYER = "com/adcc/emu/client/resource/add.png";
	
	/**
	 * 打开日志窗口图标
	 */
	public static final String IMAGE_OPEN_LOG = "com/adcc/emu/client/resource/filter.png";
	
	/**
	 * 打开图层窗口图标
	 */
	public static final String IMAGE_RETRIEVE = "com/adcc/emu/client/resource/filter.png";
	
	/**
	 * 新增操作按钮
	 */
	public static final String IMAGE_NEW = "com/adcc/emu/client/resource/new.png";
	
	/**
	 * 新增操作按钮
	 */
	public static final String IMAGE_ADD_SMALL = "com/adcc/emu/client/resource/edit_add.png";
	
	/**
	 * 移除操作小图片
	 */
	public static final String IMAGE_DEL_SMALL = "com/adcc/emu/client/resource/edit_remove.png";
	
	/**
	 * 移除操作小图片
	 */
	public static final String IMAGE_INSERT_SMALL = "com/adcc/emu/client/resource/insert.png";
	
	/**
	 * 修改按钮
	 */
	public static final String IMAGE_MODIFY = "com/adcc/emu/client/resource/modify.png";
	
	/**
	 * 删除按钮
	 */
	public static final String IMAGE_DELETE = "com/adcc/emu/client/resource/delete.png";
	
	/**
	 * 保存按钮
	 */
	public static final String IMAGE_SAVE = "com/adcc/emu/client/resource/save.png";
	
	/**
	 * 导入图片
	 */
	public static final String IMAGE_IMPORT = "com/adcc/emu/client/resource/large_smartart.png";
	
	/**
	 * 导出图片
	 */
	public static final String IMAGE_EXPORT = "com/adcc/emu/client/resource/large_shapes.png";
	
	/**
	 * 上移图片
	 */
	public static final String IMAGE_UP = "com/adcc/emu/client/resource/upenable.png";
	
	/**
	 * 下移图片
	 */
	public static final String IMAGE_DOWN = "com/adcc/emu/client/resource/downenable.png";
	
	/**
	 * 查询图片
	 */
	public static final String IMAGE_FIND = "com/adcc/emu/client/resource/find.png";
	
	/**
	 * 程序的logo
	 */
	public static final String IMAGE_LOGO = "com/adcc/emu/client/resource/logo.png";
	
	/**
	 * 打开shp图层的操作
	 */
	public static final String IMAGE_GEO_OPEN_SHP = "com/adcc/emu/client/resource/OpenLayer.png";
	
	/**
	 * 连接到数据库的图标
	 */
	public static final String IMAGE_GEO_CONNECT_DB = "com/adcc/emu/client/resource/connectdb.png";
	
	/**
	 * 选中图元对象的图标
	 */
	public static final String IMAGE_GEO_SELECTOR = "com/adcc/emu/client/resource/selectgeo.png";
	
	/**
	 * 图层数据集合
	 */
	public static final String IMAGE_GEO_DATASTORE = "com/adcc/emu/client/resource/datastore.png";
	
	/**
	 * 选中数据集合
	 */
	public static final String IMAGE_GEO_SELECTDATASTORE = "com/adcc/emu/client/resource/selecteddatastore.png";
	
	/**
	 * 新增点的图片
	 */
	public static final String IMAGE_POINT_ADD = "com/adcc/emu/client/resource/point.png";
	
	/**
	 * 线条的图片
	 */
	public static final String IMAGE_LINE = "com/adcc/emu/client/resource/line.png";
	
	/**
	 * 多边形的图片
	 */
	public static final String IMAGE_POLYGON = "com/adcc/emu/client/resource/polygon.png";
	
	/**
	 * 开始编辑的图片
	 */
	public static final String IMAGE_EDIT_BEGIN = "com/adcc/emu/client/resource/geoedit.png";
	
	/**
	 * 结束编辑的图片
	 */
	public static final String IMAGE_EDIT_END = "com/adcc/emu/client/resource/geosave.png"; 
	
	/**
	 * 选择地理信息对象图片
	 */
	public static final String IMAGE_GEO_SELECT = "com/adcc/emu/client/resource/selectgeo.png";
	/**
	 * 简单选择对象
	 */
	public static final String IMAGE_GEO_SIMPLE_SELECT = "com/adcc/emu/client/resource/pointer.png";
	/**
	 * 移除点的图片
	 */
	public static final String IMAGE_GEO_REMOVE = "com/adcc/emu/client/resource/removegeo.png";
	/**
	 * 编辑物理跑道图标
	 */
	public static final String IMAGE_ADD_RUNWAY = "com/adcc/emu/client/resource/runway.png";
	/**
	 * 编辑逻辑跑道图标
	 */
	public static final String IMAGE_ADD_RUNWAY_LOGIC = "com/adcc/emu/client/resource/runwayLogic.png";
	/**
	 * 地面点
	 */
	public static final String IMAGE_ADD_GROUND_POINT = "com/adcc/emu/client/resource/groundPoint.png";
	
	/**
	 * 滑行道编辑按钮
	 */
	public static final String IMAGE_ADD_TAXIWAY = "com/adcc/emu/client/resource/taxiway.png";
	
	/**
	 * 延长线功能
	 */
	public static final String IMAGE_GEO_EXTENSION_LINE = "com/adcc/emu/client/resource/extension-line.png";
	
	/**
	 * 停机位编辑按钮
	 */
	public static final String IMAGE_ADD_PARKINGPOINT = "com/adcc/emu/client/resource/parkingPoint.png";
			
	/**
	 * 跑道入口编辑按钮
	 */
	public static final String IMAGE_ADD_RUNWAYENTRY = "com/adcc/emu/client/resource/runwayEntry.png";
	
	/**
	 * 跑道出口编辑按钮
	 */
	public static final String IMAGE_ADD_RUNWAYEXIT = "com/adcc/emu/client/resource/runwayExit.png";
	
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
