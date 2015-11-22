<!--MODALS-->
<div class="modal fade" id="aboutProject">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">About the project</h4>
			</div>
			<div class="modal-body">
				<p>This project is about making a sound uploading service.</p>
			</div>
			<div class="modal-footer">
				<button aria-label="Close" class="btn btn-default" data-dismiss="modal"
				type="button">Close</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="advancedSearch">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Advanced settings</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label" for="stations">Station:</label>
						<div class="col-sm-10">
							<select class="form-control" id="stations" name="stations">
								<option value="ruv">
									Rúv
								</option>
								<option value="ruvithrottir">
									Rúv-íþróttir
								</option>
								<option value="stod2">
									Stöð2
								</option>
								<option value="stod2sport">
									Stöð2-sport
								</option>
								<option value="stod2sport2">
									Stöð2-sport2
								</option>
								<option value="stod2gull">
									Stöð2-gull
								</option>
								<option value="stod2bio">
									Stöð2-bio
								</option>
								<option value="stod3">
									Stöð3
								</option>
								<option value="skjar1">
									Skjár1
								</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="date">Day:</label>
						<div class="col-sm-10">
							<div class="date-container">
								<input class="form-control" id="date" name="date" type="date">
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button aria-label="Close" class="btn btn-default" data-dismiss="modal"
				type="button">Close</button><button aria-label="Close" class=
				"searchBtn btn btn-default" data-dismiss="modal" type=
				"button">Search</button>
			</div>
		</div>
	</div>
</div>