/*var fields = [{name: 'id', type: 'int'},{name:'config_key'}, {name:'config_value'}];
var nameModel = 'sysConfigModel';
var urlLoad = '/configData';
var width = '80%';
var height= 600; */
var urlChangle = '/sysConfig/changle';
Ext.onReady(function() {

	function loadData(urlData) {
		Ext.Ajax.request({
			url: urlData,
			success: function(response, opts) {
				var obj = Ext.decode(response.responseText);
				var val = obj[0];
				for (var j in val) {
					return j;
				}
			},

			failure: function(response, opts) {
				console.log('server-side failure with status code ' + response.status);
			}
		});
	}

	function changleData(dataConfig, dataStore) {
		Ext.Ajax.request({
			url: urlChangle,
			method: 'POST',
			headers: { 'Content-Type': 'application/json' },
			jsonData: dataConfig,
			success: function(response, opts) {
				dataStore.load();
				var obj = Ext.decode(response.responseText);
				console.dir(obj);
			},
			failure: function(response, opts) {
				console.log('server-side failure with status code ' + response.status);
			}
		});
	}

	function createModel(nameModel, fields) {
		return Ext.define(nameModel, {
			extend: 'Ext.data.Model',
			fields: fields
		});
	}

	function createStone(nameModel, fields, urlLoad) {
		return Ext.create('Ext.data.Store', {
			autoLoad: true,
			autoSync: true,
			model: createModel(nameModel, fields),
			proxy: {
				type: 'ajax',
				url: urlLoad,
				reader: {
					type: 'json',
					rootProperty: 'data'
				},
				writer: {
					type: 'json'
				}
			}
		});
	}
	function createController(modelName, controllerName, urlRemove) {
		return Ext.define('configController', {
			extend: 'Ext.app.ViewController',
			alias: 'controller.' + controllerName,
			onAddClick: function() {
				var store = this.getView().getStore();
				var model = Ext.create(modelName);
				model.set("id", 0);
				store.insert(0, model);
			},

			onLoadClick: function() {
				var store = this.getView().getStore();
				store.load();
			},
			onRemoveClick: function() {
				var store = this.getView().getStore();
				var selectedRows = this.getView().getSelectionModel().getSelection();
				Ext.Msg.confirm('Confirm', 'Are you sure you want delete this column?', function(btn) {
					if (btn == 'yes') {
						Ext.Ajax.request({
							url: urlRemove + selectedRows[0].data.id,

							success: function(response, opts) {
								var obj = Ext.decode(response.responseText);
								console.dir(obj);
							},

							failure: function(response, opts) {
								console.log('server-side failure with status code ' + response.status);
							}
						});
						store.remove(selectedRows);
					}
					else {
						return;
					}
				}
				)
			},
			updateClick: function() {
				var grid = this.getView();
				var dataStore = grid.getStore();
				var selectedRows = grid.getSelectionModel().getSelection();
				var dataConfig = selectedRows[0].data;
				changleData(dataConfig, dataStore);
			}
		});
	}

	function createPanel(width, height, modelName, controllerName, urlLoad, urlRemove, fields, column) {
		createController(modelName, controllerName, urlRemove);
		return Ext.create('Ext.grid.Panel', {
			renderTo: 'helloWorldPanel',
			width: width,
			height: height,
			title: 'Sys Config',
			controller: controllerName,
			listeners: {
				selectionchange: function(sender, record, isSelected) {
					var removeBtn = this.lookupReference('btnRemove');
					if (record.length)
						removeBtn.setDisabled(false);
					else
						removeBtn.setDisabled(true);
				}
			},
			store: createStone(modelName, fields, urlLoad),
			columns: column,
			plugins: {
				ptype: 'rowediting',
				listeners: {
					edit: 'updateClick'
				},
				clicksToEdit: 2
			},
			tbar: [{
				text: 'Add SysConfig',
				handler: 'onAddClick'
			}, {
				text: 'Remove SysConfig',
				reference: 'btnRemove',
				handler: 'onRemoveClick',
				disabled: true
			}]

		});
	}

	loadData('/configData');

	createPanel('80%', 300, 'sysConfigModel', 'sysConfigContr', '/configData', '/sysConfig', [{ name: 'id', type: 'int' }, { name: 'config_key' }, { name: 'config_value' }],
		[{
			text: "Id",
			dataIndex: 'id',
			flex: 1
		}, {
			text: "config_key",
			dataIndex: 'config_key',
			hidden: false,
			flex: 1,
			editor:
			{
				allowBlank: true
			}
		}, {
			text: "config_value",
			dataIndex: 'config_value',
			hidden: false,
			flex: 1,
			editor:
			{
				allowBlank: true
			},
			items:[{
		        xtype: 'searchtrigger',
		        autoSearch: true
		    }]
		}]);

});
 function edit_show() {
            document.getElementById('edit').style.display = "block";
        }
  function edit_hide() {
            document.getElementById('edit').style.display = "none";
  }