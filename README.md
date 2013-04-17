MyFirstJEEApp
=============


## �ŏ��̈��
- Java EE Module�����
  - web.xml�������ō���邯�ǁC�Ȃ�ł� 2.5 �Ȃ̂ŁC3.0 �ɒ����Ă���
- Project Structure��Module->Add��EJB�Ƃ�JPA�Ȃǂ�facet��ǉ������JavaEE5��javaee.jar������Ă���̂ŁC�܂��������_��
  - Module->Dependencies->Add��Library��from maven���� "javax:javaee-api:6.0" ��ǉ����悤���C�Ȃ�ł��_�E�����[�h�Ɏ��s����B:-(
  - �������Ȃ��̂ŁC[���̂ւ�](http://mvnrepository.com/artifact/javax/javaee-api/6.0) ���� javaee-api-6.0.jar ���Q�b�g
  - ./lib ������ɔz�u���ă��C�u�����ɒǉ��iscope��provided�j
- �������������� artifact �� war�t�@�C������āCglassfish�w�肵�đa�ʊm�F���Ƃ�

## �͂��߂Ă�Servlet3.0
- Web�c�[���E�B���h�E����Servlet�����ƁCServlet2.5�R���̃T�[�u���b�g�ɂȂ�̂ŁC���ʂɃN���X�����

## �͂��߂Ă�JPA2.0
- Project Structure��Module->Add��JPA��ǉ�
  - JPA Provider�� EclipseLink�Cpersistence.xml �� ./src/META-INF �ɍ��i�����Ă����� ./META-INF �ɍ��j
- persistence.xml�͋���ۂȂ̂ŁC�Œ���K�v�ȕ�����ǉ�
  - �ǉ����� persistence.xml �� artifact �ł� war �t�@�C���Ɋ܂߂�悤�ɐݒ肵�Ă����i�Y�ꂪ���j
- JPA���g���ɂ́Cglassfish���Ƀf�[�^�\�[�X���`���Ȃ��ƃ_���Ȃ̂����C�Ǘ��c�[�����g������CDB��p�ӂ�����ƃ����h�E������
  - ...�̂ŁCDB�͕ʂɗp�ӂ����Cglassfish���� Embedded Derby ������Ă��܂�
  - glassfish-resources.xml�ɐڑ��v�[����f�[�^�\�[�X���`���āCasadmin�o�R��glassfish�ɓo�^���邱�Ƃ��ł���
  - glassfish�ɖ��ߍ��� Embedded Derby �̎��̂́C$GLASSFISH_HOME/glassfish/domains/domain1/config �ɂł�������
- JPA Entity��JPA�c�[���E�B���h�E������Ƃ�₱�������ƂɂȂ�̂ŁC���ʂɃN���X�Ƃ��č��
- **���������΁CJPA Entity�̒P�̃e�X�g���Ăǂ�����Ă��񂾂낤�H**

## �͂��߂Ă�EJB3.1
- EJB facet�͗v��Ȃ��iEJB3.0�����炩�ȁH�j
- ���ʂ̃N���X����銴�o�ŁC�K���ȏꏊ��EJB3�̃Z�b�V�����r�[�������istateless�ł����ł���j
- ����͂����ƁC@PersistenceContext �� unitName ���ĕ⊮�����Ȃ��̂�ˁB:-(

## �͂��߂Ă�JSF2.2
- Project Structure��Module->Web->Add��JSF��ǉ��ifacelet��Enabled�ɂ��Ƃ��j
  - �uJSF�̃��C�u����������v�ƌ����邪 javaee-api-6.0.jar ��ݒ�ς݂Ȃ̂Ŗ������Č����i�G���[�ɂȂ�Ȃ��j
- web.xml��FacesServlet�Ȃǂ�JSF�̐ݒ��������
- index.jsp�������āC�����index.xhtml�����
- �܂���JSF�̊Ǘ��r�[��������Ă݂�

## �͂��߂Ă�CDI1.0
- Project Structure��Module��CDI Facet��ǉ����Ȃ��Ă��ǂ��ijavaee-api-6.0.jar�Ɋ܂܂�Ă��邵�C�����ɒǉ�����̂�����j
  - �v��̂��ǂ����킩��Ȃ����ǁC./web/WEB-INF/beans.xml ��ǉ����Ƃ��i��������G���[�ɂȂ�������C�v��񂾂���j
- JSF�̊Ǘ��r�[����CDI�ɕς��Ă���
  - @ManagedBean �� @Model @Name(value="...") �ɕς��Ă����i@Model ����������C�����Ă���悤�œ����Ȃ��Ȃ����j
  - @EJB �� @Inject �ɕς���i@EJB�̂܂܂ł��g�����j
- **CDI���Ďg�������������̂��悭�킩���B(�L��֥`)**

